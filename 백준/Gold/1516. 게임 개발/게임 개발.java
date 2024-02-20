import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static BufferedReader bReader;
	static StringTokenizer st;
	static ArrayList<PriorityQueue<Node>> graph;

	static class Node implements Comparable<Node> {
		int time;
		int num;

		public Node(int time, int num) {
			this.time = time;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine().trim());
		n = Integer.parseInt(st.nextToken());

		int[] time = new int[n + 1];
		int[] inDegree = new int[n + 1];

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			graph.add(new PriorityQueue<Node>());

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bReader.readLine().trim());
			int spend = Integer.parseInt(st.nextToken());
			time[i] = spend;
			int x;
			while (!((x = Integer.parseInt(st.nextToken())) == -1)) {
				graph.get(x).add(new Node(spend, i));
				inDegree[i]++;
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				q.add(new Node(time[i], i));
		}

		while (!q.isEmpty()) {
			Node now = q.poll();
			while (!graph.get(now.num).isEmpty()) {
				Node out = graph.get(now.num).poll();
				if (inDegree[out.num] == 1)
					time[out.num] += time[now.num];
				inDegree[out.num]--;
				if (inDegree[out.num] == 0)
					q.add(new Node(time[out.num], out.num));
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(time[i]);
		}
	}
}