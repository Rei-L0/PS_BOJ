import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int SIZE = 5;

	static int ans = Integer.MAX_VALUE;

	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static int[][][] board;

	static class Person {
		int x;
		int y;
		int z;
		int m;

		public Person(int x, int y, int z, int m) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.m = m;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[SIZE][SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < SIZE; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		permutation(0, new boolean[SIZE], new int[SIZE]);

		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);

	}

	static void permutation(int idx, boolean[] visit, int[] arr) {
		if (idx == SIZE) {
			solve(0, 0, arr, new int[SIZE]);
			return;
		}
		for (int i = 0; i < SIZE; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			arr[idx] = i;
			permutation(idx + 1, visit, arr);
			visit[i] = false;
		}
	}

	static void solve(int idx, int cnt, int[] arr, int[] rotateCnt) {
		if (idx == SIZE) {
			bfs(arr, rotateCnt, new Person(0, 0, 0, 0), new Person(SIZE - 1, SIZE - 1, SIZE - 1, 0));
			bfs(arr, rotateCnt, new Person(0, SIZE - 1, 0, 0), new Person(SIZE - 1, 0, SIZE - 1, 0));
			bfs(arr, rotateCnt, new Person(SIZE - 1, 0, 0, 0), new Person(0, SIZE - 1, SIZE - 1, 0));
			bfs(arr, rotateCnt, new Person(SIZE - 1, SIZE - 1, 0, 0), new Person(0, 0, SIZE - 1, 0));
			return;
		}
		if (cnt < 3) {
			rotateCnt[idx] = cnt;
			solve(idx + 1, cnt, arr, rotateCnt);
			rotateCnt[idx] = cnt + 1;
			solve(idx, cnt + 1, arr, rotateCnt);
		} else if (cnt == 3) {
			solve(idx + 1, 0, arr, rotateCnt);
		}
	}

	static int[][] rotate(int[][] arr, int num) {
		int[][] arr2 = new int[SIZE][SIZE];
		for (int j = 0; j < SIZE; j++) {
			for (int i = 0; i < SIZE; i++) {
				arr2[i][j] = arr[i][j];
			}
		}

		Queue<Integer>[] tmp = new Queue[SIZE];

		while (num-- > 0) {
			for (int i = 0; i < SIZE; i++) {
				tmp[i] = new ArrayDeque<>();
			}
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					tmp[i].offer(arr2[i][j]);
				}
			}
			for (int j = SIZE - 1; j >= 0; j--) {
				for (int i = 0; i < SIZE; i++) {
					arr2[i][j] = tmp[SIZE - 1 - j].poll();
				}
			}
		}

		return arr2;
	}

	static void bfs(int[] arr, int[] rotateCnt, Person start, Person end) {
		int[][][] cube = new int[SIZE][SIZE][SIZE];
		boolean[][][] visit = new boolean[SIZE][SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			cube[i] = rotate(board[arr[i]], rotateCnt[i]);
		}

		if (cube[start.z][start.x][start.y] == 0)
			return;

		ArrayDeque<Person> q = new ArrayDeque<>();

		q.add(start);

		visit[start.z][start.x][start.y] = true;

		while (!q.isEmpty()) {
			Person now = q.poll();
			if (now.x == end.x && now.y == end.y && now.z == end.z) {
				ans = Math.min(ans, now.m);
				return;
			}
			for (int i = 0; i < 6; i++) {
				int nz = now.z + dz[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nz < 0 || nx >= SIZE || ny >= SIZE || nz >= SIZE)
					continue;
				if (cube[nz][nx][ny] == 0 || visit[nz][nx][ny])
					continue;
				q.add(new Person(nx, ny, nz, now.m + 1));
				visit[nz][nx][ny] = true;
			}
		}
	}
}