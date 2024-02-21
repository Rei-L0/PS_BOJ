import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] d;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Pos> list;
	static int n, m, ans = Integer.MAX_VALUE;

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void solve(int start) {
		if (start == list.size()) {
			int[][] arr = new int[n][m];
			init(arr);

			// 감시 카메라 설정
			for (int i = 0; i < list.size(); i++) {
				Pos now = list.get(i);
				switch (board[now.x][now.y]) {
				case 1:
					one(i, d[i], arr);
					break;
				case 2:
					two(i, d[i], arr);
					break;
				case 3:
					three(i, d[i], arr);
					break;
				case 4:
					four(i, d[i], arr);
					break;
				case 5:
					five(i, d[i], arr);
					break;
				}
			}
			ans = Math.min(ans, calc(arr));
			return;
		}

		for (int i = 0; i < 4; i++) {
			d[start] = i;
			solve(start + 1);
		}
	}

	static void init(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = board[i][j];
			}
		}
	}

	static boolean isOut(int x, int y) {
		return (x == -1 || y == -1 || x == n || y == m || board[x][y] == 6);
	}

	static void one(int idx, int d, int[][] arr) {
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isOut(nx, ny))
				return;
			arr[nx][ny] = -1;
			x = nx;
			y = ny;
		}
	}

	static void two(int idx, int d, int[][] arr) {
		// 상하
		if (d == 0 || d == 1) {
			one(idx, 0, arr);
			one(idx, 1, arr);
		}
		// 좌우
		else {
			one(idx, 2, arr);
			one(idx, 3, arr);
		}
	}

	static void three(int idx, int d, int[][] arr) {
		// 상우
		if (d == 1) {
			one(idx, 1, arr);
			one(idx, 2, arr);
		} else if (d == 2) {
			one(idx, 2, arr);
			one(idx, 0, arr);
		} else if (d == 0) {
			one(idx, 0, arr);
			one(idx, 3, arr);
		} else {
			one(idx, 3, arr);
			one(idx, 1, arr);
		}
	}

	static void four(int idx, int d, int[][] arr) {
		// 상우
		if (d == 1) {
			one(idx, 1, arr);
			two(idx, 2, arr);
		} else if (d == 2) {
			one(idx, 2, arr);
			two(idx, 0, arr);
		} else if (d == 0) {
			one(idx, 0, arr);
			two(idx, 4, arr);
		} else {
			one(idx, 3, arr);
			two(idx, 1, arr);
		}
	}

	static void five(int idx, int d, int[][] arr) {
		for (int i = 0; i < 4; i++) {
			one(idx, i, arr);
		}
	}

	static int calc(int[][] arr) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bReader.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= board[i][j] && board[i][j] <= 5) {
					list.add(new Pos(i, j));
				}
			}
		}

		d = new int[list.size()];
		solve(0);

		System.out.println(ans);

	}
}