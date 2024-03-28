import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = 10_000_000;
	static int t, ans, n;

	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(graph[i], INF);
			ans = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1)
						graph[i][j] = x;
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i == j) {
							graph[i][j] = 0;
							continue;
						}
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			ans = calc();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int calc() {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				cnt += graph[i][j];
			}
			res = Math.min(res, cnt);
		}
		return res;
	}

}