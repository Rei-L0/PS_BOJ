import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = -1;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t, w, ans;

	static int[] num;

	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		num = new int[t + 1];
		for (int i = 1; i < t + 1; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[3][w + 1][t + 1];
		init();
		dp[1][0][0] = 0;

		for (int i = 1; i < t + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (num[i] == 1) {
					solve(i, j, 1, 2);
				} else {
					solve(i, j, 2, 1);
				}
			}
		}

		for (int j = 0; j < w + 1; j++) {
			ans = Math.max(ans, dp[1][j][t]);
			ans = Math.max(ans, dp[2][j][t]);
		}
		System.out.println(ans);
	}

	static void init() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < w + 1; j++) {
				for (int k = 0; k < t + 1; k++) {
					dp[i][j][k] = INF;
				}
			}
		}
	}

	static void solve(int i, int j, int s, int e) {
		if (dp[s][j][i - 1] != INF)
			dp[s][j][i] = Math.max(dp[s][j][i - 1] + 1, dp[s][j][i]);
		if (dp[e][j][i - 1] != INF && j != w)
			dp[s][j + 1][i] = Math.max(dp[e][j][i - 1] + 1, dp[s][j + 1][i]);
		dp[e][j][i] = Math.max(dp[e][j][i], dp[e][j][i - 1]);
	}

}