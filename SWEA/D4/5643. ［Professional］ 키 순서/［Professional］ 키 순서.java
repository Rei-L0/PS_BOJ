import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m, t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());

			boolean[][] check = new boolean[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				check[s][e] = true;
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (check[i][k] && check[k][j]) {
							check[i][j] = true;
						}
					}
				}
			}

			int[] res = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (check[i][j] || check[j][i]) {
						res[i]++;
					}
				}
			}
			int ans = 0;
			for (int x : res) {
				if (x == n - 1) {
					ans++;
				}
			}
			sb.append("#").append(tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}