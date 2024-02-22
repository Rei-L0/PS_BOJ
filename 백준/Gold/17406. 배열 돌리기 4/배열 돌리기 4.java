import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int t, n, m, k, ans;

	static int[][] board;
	static ArrayList<Oper> list;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Oper {
		int r;
		int c;
		int s;

		public Oper(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;
		board = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(bReader.readLine());
			for (int j = 1; j < m + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bReader.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new Oper(r, c, s));
		}
	}

	static void permutation(int count, int[] arr, boolean[] visit) {
		if (count == k) {
			int[][] map = new int[n + 1][m + 1];
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					map[i][j] = board[i][j];
				}
			}
			ans = Math.min(ans, solve(arr, map));
		}
		for (int i = 0; i < k; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			arr[count] = i;
			permutation(count + 1, arr, visit);
			visit[i] = false;
		}
	}

	static int solve(int[] arr, int[][] map) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			Oper now = list.get(arr[i]);
			int rotateCount = now.s;
			while (rotateCount != 0) {
				rotate(now.r, now.c, rotateCount, map);
				rotateCount--;
			}
		}
		for (int i = 1; i < n + 1; i++)
			res = Math.min(Arrays.stream(map[i]).sum(), res);
		return res;
	}

	static void rotate(int r, int c, int s, int[][] map) {
		int x = r - s;
		int y = c - s;
		int next = map[x][y];
		int now = 0;
		int i = 0;
		while (i != 4) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!(r - s <= nx && nx <= r + s && c - s <= ny && ny <= c + s)) {
				i++;
				continue;
			}
			now = map[nx][ny];
			map[nx][ny] = next;
			next = now;
			x = nx;
			y = ny;
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));

		init();
		permutation(0, new int[k], new boolean[k]);
		System.out.println(ans);

	}
}