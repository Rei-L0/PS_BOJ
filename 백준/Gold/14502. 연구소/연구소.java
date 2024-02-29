import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans;

	static int[][] board;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static ArrayList<Pos> wallList = new ArrayList<>();
	static ArrayList<Pos> virusList = new ArrayList<>();

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void combi(int start, int count, int[] res) {
		if (count == 3) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = board[i][j];
				}
			}
			for (int i : res) {
				Pos wall = wallList.get(i);
				map[wall.x][wall.y] = 1;
			}
			solve(map);
			return;
		}
		for (int i = start; i < wallList.size(); i++) {
			res[count] = i;
			combi(i + 1, count + 1, res);
		}
	}

	static void solve(int[][] map) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		for (Pos virus : virusList) {
			q.add(virus);
		}

		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx == -1 || ny == -1 || nx == n || ny == m)
					continue;
				if (map[nx][ny] != 0)
					continue;
				map[nx][ny] = 2;
				q.add(new Pos(nx, ny));
			}
		}
		ans = Math.max(ans, check(map));
	}

	static int check(int[][] map) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					wallList.add(new Pos(i, j));
				if (board[i][j] == 2)
					virusList.add(new Pos(i, j));
			}
		}
		combi(0, 0, new int[3]);
		sb.append(ans);
		System.out.println(sb);
	}
}