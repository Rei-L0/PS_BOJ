import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int SIZE = 26;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m;

	static boolean[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		graph = new boolean[SIZE][SIZE];

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			char a = st.nextToken().charAt(0);
			String is = st.nextToken();
			char b = st.nextToken().charAt(0);

			graph[a - 'a'][b - 'a'] = true;
		}

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			char a = st.nextToken().charAt(0);
			String is = st.nextToken();
			char b = st.nextToken().charAt(0);

			sb.append(solve(a - 'a', b - 'a')).append("\n");
		}

		System.out.print(sb);
	}

	static String solve(int s, int e) {
		boolean[] visit = new boolean[SIZE];
		Queue<Integer> q = new ArrayDeque<>();

		q.add(s);
		visit[s] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < SIZE; i++) {
				if (visit[i])
					continue;
				if (graph[now][i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}

		return visit[e] ? "T" : "F";
	}

}