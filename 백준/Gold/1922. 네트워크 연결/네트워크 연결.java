import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int v, e, t;
	static int ans;

	static ArrayList<Node> graph;
	static int[] p;

	static BufferedReader bReader;
	static StringTokenizer st;

	static class Node implements Comparable<Node> {
		int s;
		int t;
		int w;

		public Node(int s, int t, int w) {
			this.s = s;
			this.t = t;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		v = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bReader.readLine());
		e = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		p = new int[v + 1];
		for (int i = 0; i < v + 1; i++) {
			p[i] = i;
		}
		ans = 0;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bReader.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.add(new Node(s, t, w));
		}

		Collections.sort(graph);

	}

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		p[x] = p[y];
		return true;
	}

	static void solve() {
		for (int i = 0; i < graph.size(); i++) {
			Node now = graph.get(i);
			if (union(now.s, now.t))
				ans += now.w;
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
		System.out.println(ans);
	}
}