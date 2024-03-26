import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans;

	static int[] mem, c;

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		mem = new int[n + 1];
		c = new int[n + 1];

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			mem[i + 1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			c[i + 1] = Integer.parseInt(st.nextToken());
			cnt += c[i + 1];
		}

		ans = cnt;
		dp = new int[n + 1][cnt + 1];

		for (int i = 1; i < n + 1; i++) {
			int nowC = c[i];
			for (int j = 0; j < cnt + 1; j++) {
				if (j < nowC) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - nowC] + mem[i], dp[i - 1][j]);
				}
				if (dp[i][j] >= m) {
					ans = Math.min(ans, j);
				}
			}
		}

		System.out.println(ans);
	}

}