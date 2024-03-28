import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 100_000_000;

	static int n, m;

	static int[][] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		d = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++)
			Arrays.fill(d[i], INF);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			d[s][e] = Math.min(d[s][e], w);
		}

		floyd();
		print();

	}

	static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						d[i][j] = 0;
						continue;
					}
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(d[i][j] == INF ? 0 : d[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}