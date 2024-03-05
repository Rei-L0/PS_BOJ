import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, count = 1;

	static int[] degree, ans;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		degree = new int[n + 1];
		ans = new int[n + 1];
		graph = new ArrayList();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			degree[e]++;
		}

		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) {
				q.add(i);
				ans[i] = count;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				degree[next]--;
				if (degree[next] == 0) {
					ans[next] = ans[now] + 1;
					q.add(next);
				}
			}
		}

		for (int i = 1; i < n + 1; i++)
			System.out.print(ans[i] + " ");

	}

}