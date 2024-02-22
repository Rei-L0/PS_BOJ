import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans, max;
	static int[] p, size;
	static ArrayList<Node> graph;

	static class Node implements Comparable<Node> {
		int s;
		int e;
		int w;

		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static void kruskal() {
		for (int i = 0; i < graph.size(); i++) {
			Node now = graph.get(i);
			if (union(now.s, now.e)) {
				ans += now.w;
				max = now.w;
			}
		}
	}

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY)
			return false;

		if (size[rootX] < size[rootY]) {
			p[rootX] = rootY;
			size[rootY] += size[rootX];
		} else {
			p[rootY] = rootX;
			size[rootX] += size[rootY];
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.add(new Node(s, e, w));
		}

		p = new int[n + 1];
		size = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
			size[i] = 1;
		}

		Collections.sort(graph);

		kruskal();

		System.out.println(ans - max);

	}
}