import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, k;

	static int[][] dp;

	static ArrayList<Knap> list = new ArrayList<>();

	static class Knap {
		int w;
		int v;

		public Knap(int w, int v) {
			this.w = w;
			this.v = v;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][k + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Knap(w, v));
		}

		for (int i = 1; i < n + 1; i++) {
			Knap now = list.get(i - 1);
			for (int j = 1; j < k + 1; j++) {
				if (now.w > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(now.v + dp[i - 1][j - now.w], dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][k]);
	}

}