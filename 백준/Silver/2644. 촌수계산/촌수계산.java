import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans = 0;
	static int[][] graph;

	private static void solve(int count, int start, int end, boolean[] visit) {
		if (start == end) {
			ans = count;
			return;
		}
		visit[start] = true;
		for (int i = 1; i < graph[start].length; i++) {
			int cur = graph[start][i];
			if (cur != 0 && !visit[cur]) {
				solve(count + 1, cur, end, visit);
			}
			if (cur == 0)
				return;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stringTokenizer.nextToken());
		int end = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(br.readLine());
		m = Integer.parseInt(stringTokenizer.nextToken());

		graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stringTokenizer.nextToken());
			int e = Integer.parseInt(stringTokenizer.nextToken());
			for (int j = 1; j < graph[s].length; j++) {
				if (graph[s][j] == 0) {
					graph[s][j] = e;
					break;
				}
			}
			for (int j = 1; j < graph[e].length; j++) {
				if (graph[e][j] == 0) {
					graph[e][j] = s;
					break;
				}
			}
		}
		solve(0, start, end, new boolean[n + 1]);
		if (ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}