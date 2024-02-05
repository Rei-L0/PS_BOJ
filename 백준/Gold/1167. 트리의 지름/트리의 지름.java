import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
	int next;
	int w;

	public Node(int next, int w) {
		this.next = next;
		this.w = w;
	}
}

public class Main {
	static int n, MaxNode = 0, MaxVal = 0;
	static HashMap<Integer, ArrayList<Node>> tree;

	static void dfs(boolean[] visit, int start, int count) {
		visit[start] = true;
		ArrayList<Node> cur = tree.get(start);
		for (int i = 0; i < cur.size(); i++) {
			Node nextNode = cur.get(i);
			if (!visit[nextNode.next]) {
				dfs(visit, nextNode.next, count + nextNode.w);
			}
		}
		if (MaxVal < count) {
			MaxNode = start;
			MaxVal = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		tree = new HashMap<>();

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			tree.put(s, new ArrayList<>());
			int e;
			while ((e = Integer.parseInt(st.nextToken())) != -1) {
				int w = Integer.parseInt(st.nextToken());
				ArrayList<Node> cur = tree.get(s);
				cur.add(new Node(e, w));
				tree.put(s, cur);
			}
		}
		dfs(new boolean[n + 1], 1, 0);
		dfs(new boolean[n + 1], MaxNode, 0);
		System.out.println(MaxVal);
	}

}