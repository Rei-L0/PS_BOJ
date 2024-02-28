import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;

	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };
	static int[][] board;

	static void solve(int x, int y, int d) {
		if (x >= n || y >= n)
			return;
		if (board[x][y] == 1)
			return;
		if (x == n - 1 && y == n - 1) {
			ans++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (d == 0 && i == 1)
				continue;
			if (d == 1 && i == 0)
				continue;
			if (i == 2 && !check(x, y))
				continue;
			solve(x + dx[i], y + dy[i], i);
		}
	}

	static boolean check(int x, int y) {
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= n || ny >= n)
				continue;
			if (board[nx][ny] == 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer to = new StringTokenizer(br.readLine());

		n = Integer.parseInt(to.nextToken());

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			to = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(to.nextToken());
			}
		}

		solve(0, 1, 0);
		System.out.println(ans);
	}
}