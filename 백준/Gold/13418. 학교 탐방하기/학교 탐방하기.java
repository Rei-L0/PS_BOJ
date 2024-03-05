import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k, ans, max, min;

	static int[] p;

	static ArrayList<Node> edges;

	static class Node {
		int s;
		int e;
		int w;

		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edges = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int ss = Integer.parseInt(st.nextToken());
		int se = Integer.parseInt(st.nextToken());
		int sw = Integer.parseInt(st.nextToken());
		
		if (sw == 0) {
			sw = 1;
		} else {
			sw = 0;
		}

		max = sw;
		min = sw;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (w == 0) {
				w = 1;
			} else {
				w = 0;
			}
			edges.add(new Node(s, e, w));
		}

		edges.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		p = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
		}

		for (int i = 0; i < m; i++) {
			Node now = edges.get(i);
			if (union(now.e, now.s)) {
				min += now.w;
			}
		}

		edges.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o2.w, o1.w);
			}
		});

		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
		}

		for (int i = 0; i < m; i++) {
			Node now = edges.get(i);
			if (union(now.e, now.s)) {
				max += now.w;
			}
		}

		System.out.println((max * max) - (min * min));
	}
}