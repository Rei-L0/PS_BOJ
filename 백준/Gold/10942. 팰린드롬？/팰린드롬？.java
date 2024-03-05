import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	static int[] num;
	static int[][] dp;

	static void solve() {
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int i = 0; i < n - 1; i++) {
			if (num[i] == num[i + 1])
				dp[i][i + 1] = 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 2; j < n; j++) {
				if (num[i] == num[j] && dp[i + 1][j - 1] == 1)
					dp[i][j] = 1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n][n];

		solve();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s - 1][e - 1]).append("\n");
		}
		System.out.print(sb);
	}

}