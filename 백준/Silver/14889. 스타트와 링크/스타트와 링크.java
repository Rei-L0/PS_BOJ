import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int t, n, ans;
	static int[][] board;

	static void solve(int start, int count, boolean[] a) {
		if (count == n / 2) {
			int team1 = 0;
			int team2 = 0;
			for (int i = 0; i < n; i++) {
				if (a[i]) {
					for (int j = 0; j < n; j++) {
						if (i != j && a[j])
							team1 += board[i][j];
					}
				} else {
					for (int j = 0; j < n; j++) {
						if (i != j && !a[j])
							team2 += board[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(team1 - team2));
		}
		for (int i = start; i < n; i++) {
			a[i] = true;
			solve(i + 1, count + 1, a);
			a[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, new boolean[n]);
		System.out.println(ans);
	}
}