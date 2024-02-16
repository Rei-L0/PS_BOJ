import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static long maxValue, maxNode;
	static ArrayList<ArrayList<Node>> arrayList;
	static long[] distance;
	static PriorityQueue<Node> pQueue = new PriorityQueue<>();

	static class Node implements Comparable<Node> {
		int to;
		long c;

		public Node(int to, long c) {
			this.to = to;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.c, o.c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arrayList = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			arrayList.add(new ArrayList<Node>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arrayList.get(v).add(new Node(u, c));
		}

		distance = new long[n + 1];
		Arrays.fill(distance, 100_000_000_000L);

		st = new StringTokenizer(bReader.readLine());
		for (int i = 0; i < k; i++) {
			int s = Integer.parseInt(st.nextToken());
			distance[s] = 0;
			pQueue.add(new Node(s, 0));
		}

		while (!pQueue.isEmpty()) {
			Node now = pQueue.poll();
			if (distance[now.to] < now.c)
				continue;
			for (int i = 0; i < arrayList.get(now.to).size(); i++) {
				Node next = arrayList.get(now.to).get(i);
				if (distance[next.to] > now.c + next.c) {
					distance[next.to] = now.c + next.c;
					pQueue.add(new Node(next.to, distance[next.to]));
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (maxValue < distance[i]) {
				maxNode = i;
				maxValue = distance[i];
			}
		}

		System.out.println(maxNode);
		System.out.println(maxValue);

	}
}