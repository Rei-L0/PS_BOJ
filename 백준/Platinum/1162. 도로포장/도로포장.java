import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, k;

	static long ans = Long.MAX_VALUE;

	static class Edge implements Comparable<Edge> {
		int to;
		long w;
		int k;

		public Edge(int to, long w, int k) {
			super();
			this.to = to;
			this.w = w;
			this.k = k;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		List<List<Edge>> graph = new ArrayList<>();

		long[][] dis = new long[k + 1][n + 1];

		for (int i = 0; i < k + 1; i++)
			Arrays.fill(dis[i], Long.MAX_VALUE);

		dis[0][1] = 0;

		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Edge(e, w, 0));
			graph.get(e).add(new Edge(s, w, 0));
		}

		dijk(graph, dis);

		for (int i = 0; i < k + 1; i++) {
			ans = Math.min(ans, dis[i][n]);
		}
		System.out.println(ans);
	}

	static void dijk(List<List<Edge>> graph, long[][] dis) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (dis[now.k][now.to] < now.w)
				continue;
			for (Edge next : graph.get(now.to)) {
				if (dis[now.k][next.to] > now.w + next.w) {
					dis[now.k][next.to] = now.w + next.w;
					pq.add(new Edge(next.to, dis[now.k][next.to], now.k));
				}
				if (now.k < k) {
					if (dis[now.k + 1][next.to] > now.w) {
						dis[now.k + 1][next.to] = now.w;
						pq.add(new Edge(next.to, dis[now.k + 1][next.to], now.k + 1));
					}
				}
			}
		}
	}

}