import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, ans;

	static int[] dp, before;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];
		before = new int[n + 1];

		Arrays.fill(dp, 1_000_000);
		dp[n] = 0;

		for (int i = n; i > 0; i--) {
			if (i % 3 == 0) {
				if (dp[i / 3] > dp[i] + 1) {
					dp[i / 3] = dp[i] + 1;
					before[i / 3] = i;
				}
			}
			if (i % 2 == 0) {
				if (dp[i / 2] > dp[i] + 1) {
					dp[i / 2] = dp[i] + 1;
					before[i / 2] = i;
				}
			}
			if (dp[i - 1] > dp[i] + 1) {
				dp[i - 1] = dp[i] + 1;
				before[i - 1] = i;
			}
		}
		sb.append(dp[1]).append("\n");
		int[] ans = new int[dp[1] + 1];
		ans[0] = 1;
		for (int i = 1; i <= dp[1]; i++) {
			ans[i] = before[ans[i - 1]];
		}
		for (int i = dp[1]; i >= 0; i--) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}
}