import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int n, MaxVal, MaxNode;
	static HashMap<Integer, ArrayList<Node>> graph;

	static class Node {
		int num;
		int w;

		public Node(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}

	static void solve(boolean[] visit, int start, int dis) {
		visit[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			Node cur = graph.get(start).get(i);
			if (!visit[cur.num]) {
				solve(visit, cur.num, dis + cur.w);
			}
		}
		if (dis > MaxVal) {
			MaxVal = dis;
			MaxNode = start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		graph = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			ArrayList<Node> arrayList;
			if (graph.containsKey(s)) {
				arrayList = graph.get(s);
			} else {
				arrayList = new ArrayList<>();
			}
			arrayList.add(new Node(e, w));
			graph.put(s, arrayList);

			if (graph.containsKey(e)) {
				arrayList = graph.get(e);
			} else {
				arrayList = new ArrayList<>();
			}
			arrayList.add(new Node(s, w));
			graph.put(e, arrayList);
		}
		if (n > 1) {
			solve(new boolean[n + 1], 1, 0);
			solve(new boolean[n + 1], MaxNode, 0);
		}
		System.out.println(MaxVal);
	}
}