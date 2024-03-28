import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int t, n, x, y;

	static Pos[] node;
	static int[][] graph;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());

		for (int z = 0; z < t; z++) {

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			graph = new int[n + 2][n + 2];
			node = new Pos[n + 2];

			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				node[i] = new Pos(x, y);
			}

			calcDis();

			sb.append(bfs(0)).append("\n");
		}
		System.out.println(sb);
	}

	static void calcDis() {
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				if (i == j)
					continue;
				graph[i][j] = Math.abs(node[i].x - node[j].x) + Math.abs(node[i].y - node[j].y);
			}
		}
	}

	static String bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n + 2];
		visit[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == (n + 1)) {
				return "happy";
			}
			for (int i = 0; i < n + 2; i++) {
				if (visit[i])
					continue;
				if (graph[now][i] <= 1000) {
					q.add(i);
					visit[i] = true;
				}
			}

		}
		return "sad";
	}

}