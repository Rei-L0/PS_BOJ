import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, l, ans;
	static int[][] ham;

	static void solve(int start, int k, int score) {
		if (k <= l) {
			ans = Math.max(ans, score);
			for (int i = start; i < n; i++) {
				solve(i + 1, k + ham[i][1], score + ham[i][0]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			ham = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				ham[i][0] = Integer.parseInt(st.nextToken());
				ham[i][1] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0, 0);

			System.out.println("#" + tc + " " + ans);
		}

	}

}