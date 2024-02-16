import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static ArrayList<PriorityQueue<Long>> distance;
	static ArrayList<ArrayList<Node>> graph;

	static class Node implements Comparable<Node> {
		int to;
		long w;

		public Node(int to, long w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}

	static void solve() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance.get(1).offer((long) 0);
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int i = 0; i < graph.get(now.to).size(); i++) {
				Node next = graph.get(now.to).get(i);
				if (distance.get(next.to).size() < k) {
					distance.get(next.to).offer((now.w + next.w));
					pq.add(new Node(next.to, (now.w + next.w)));
				} else if (distance.get(next.to).peek() > (now.w + next.w)) {
					distance.get(next.to).poll();
					distance.get(next.to).offer((now.w + next.w));
					pq.add(new Node(next.to, (now.w + next.w)));
				}
			}
		}

	}

	// MAX pq 사용해서 size가 k보다 작을 때는 삽입 클 때는 비교 후 poll 후 pq에 삽입.
	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		distance = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			distance.add(new PriorityQueue<>(Collections.reverseOrder()));
		}

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node(e, w));
		}
		solve();

		for (int i = 1; i < n + 1; i++) {
			if (distance.get(i).size() < k) {
				System.out.println(-1);
				continue;
			}
			for (int j = 0; j < distance.get(i).size() - k; j++) {
				distance.get(i).poll();
			}
			System.out.println(distance.get(i).poll());
		}
	}
}