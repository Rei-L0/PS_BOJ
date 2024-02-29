import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans = Integer.MAX_VALUE;
	static int[][] board;

	static void solve(int start, int now, int count, int res, boolean[] visit) {
		if (count == n - 1) {
			if (board[now][start] == 0)
				return;
			ans = Math.min(ans, res + board[now][start]);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] || board[now][i] == 0)
				continue;
			visit[i] = true;
			solve(start, i, count + 1, res + board[now][i], visit);
			visit[i] = false;

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			visit[i] = true;
			solve(i, i, 0, 0, visit);
			visit[i] = false;
		}

		System.out.println(ans);
	}
}