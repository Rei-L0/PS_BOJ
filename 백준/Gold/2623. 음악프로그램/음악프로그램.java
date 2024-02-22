import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int t, n, m;

	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayDeque<Integer> ans;

	static StringTokenizer st;
	static BufferedReader bReader;

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		inDegree = new int[n + 1];

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int num = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				int x = Integer.parseInt(st.nextToken());
				list.add(x);
			}

			for (int x = 0; x < num - 1; x++) {
				int s = list.get(x);
				int e = list.get(x + 1);
				graph.get(s).add(e);
				inDegree[e]++;
			}
		}

	}

	static void topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < n + 1; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			ans.add(now);
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				inDegree[next]--;
				if (inDegree[next] == 0)
					q.add(next);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));

		ans = new ArrayDeque<>();
		init();
		topologySort();

		if (ans.size() != n) {
			System.out.println("0");
		} else {
			while (!ans.isEmpty()) {
				System.out.println(ans.poll());
			}
		}
	}
}