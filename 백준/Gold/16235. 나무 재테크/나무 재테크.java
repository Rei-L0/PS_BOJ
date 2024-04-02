import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;

	static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dy = { 1, -1, 1, 0, -1, 1, 0, -1 };

	static int[][] ground;
	static int[][] add;

	static PriorityQueue<Tree> treeQ;
	static Queue<Tree> deathQ;

	static StringTokenizer st;
	static StringBuilder sb;

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		add = new int[n][n];
		ground = new int[n][n];

		treeQ = new PriorityQueue<>();
		deathQ = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				ground[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			treeQ.add(new Tree(x, y, z));
		}

		while (k-- > 0) {
			treeQ = spring();
			summer();
			treeQ = fall();
			winter();
		}

		System.out.println(treeQ.size());

	}

	static PriorityQueue<Tree> spring() {
		PriorityQueue<Tree> live = new PriorityQueue<Tree>();
		while (!treeQ.isEmpty()) {
			Tree now = treeQ.poll();
			if (ground[now.x][now.y] < now.age) {
				deathQ.add(now);
			} else {
				ground[now.x][now.y] -= now.age;
				live.add(new Tree(now.x, now.y, now.age + 1));
			}

		}
		return live;
	}

	static void summer() {
		while (!deathQ.isEmpty()) {
			Tree now = deathQ.poll();
			ground[now.x][now.y] += now.age / 2;
		}
	}

	static PriorityQueue<Tree> fall() {
		PriorityQueue<Tree> live = new PriorityQueue<Tree>();

		while (!treeQ.isEmpty()) {
			Tree now = treeQ.poll();
			if (now.age > 0 && now.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;
					live.add(new Tree(nx, ny, 1));
				}
			}
			live.add(now);
		}

		return live;
	}

	static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ground[i][j] += add[i][j];
			}
		}
	}
}