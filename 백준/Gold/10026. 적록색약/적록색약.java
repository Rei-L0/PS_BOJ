import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int n, ans, ans2;
	static char[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visit;
	static boolean[][] visit2;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfs(int sx, int sy) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		ans++;
		int x = sx;
		int y = sy;
		visit[x][y] = true;
		q.add(new Pos(x, y));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx == -1 || ny == -1 || nx == n || ny == n || visit[nx][ny])
					continue;
				if (board[nx][ny] == board[sx][sy]) {
					visit[nx][ny] = true;
					q.add(new Pos(nx, ny));
				}
			}
		}
	}

	static void bfs2(int sx, int sy) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		ans2++;
		int x = sx;
		int y = sy;
		visit2[x][y] = true;
		q.add(new Pos(x, y));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx == -1 || ny == -1 || nx == n || ny == n || visit2[nx][ny])
					continue;
				if (board[nx][ny] == board[sx][sy]) {
					visit2[nx][ny] = true;
					q.add(new Pos(nx, ny));
				} else if (board[sx][sy] == 'R' && board[nx][ny] == 'G') {
					visit2[nx][ny] = true;
					q.add(new Pos(nx, ny));
				} else if (board[sx][sy] == 'G' && board[nx][ny] == 'R') {
					visit2[nx][ny] = true;
					q.add(new Pos(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = string.charAt(j);
			}
		}

		visit = new boolean[n][n];
		visit2 = new boolean[n][n];

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (!visit[x][y]) {
					bfs(x, y);
				}
				if (!visit2[x][y]) {
					bfs2(x, y);
				}
			}
		}
		System.out.println(ans + " " + ans2);
	}
}