import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static BufferedReader bReader;
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] tall = new int[n + 1];
		graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			tall[b]++;
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n + 1; i++) {
			if (tall[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				tall[graph.get(now).get(i)]--;
				if (tall[graph.get(now).get(i)] == 0)
					q.add(graph.get(now).get(i));
			}
			if (now != 0)
				System.out.print(now + " ");
		}

	}
}