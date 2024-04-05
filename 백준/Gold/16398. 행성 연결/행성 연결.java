import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static long ans;

	static int[] p;

	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j)
					continue;
				pq.add(new Edge(i, j, w));
			}
		}

		kruskal();

		System.out.println(ans);
	}

	static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		p[x] = y;

		return true;
	}

	static void kruskal() {
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (union(now.s, now.e)) {
				ans += now.w;
			}
		}
	}
}