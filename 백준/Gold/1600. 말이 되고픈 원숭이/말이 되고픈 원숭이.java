import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int k, n, m, ans = Integer.MAX_VALUE;

	static int[][][] visit;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int[] hx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] hy = { 1, -1, 2, -2, 2, -2, 1, -1 };

	static int[][] board;

	static class Pos {
		int k;
		int x;
		int y;

		public Pos(int k, int x, int y) {
			this.k = k;
			this.x = x;
			this.y = y;
		}

	}

	static boolean isOut(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 1);
	}

	static void solve() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, 0));

		while (!q.isEmpty()) {
			Pos now = q.poll();
			int d = visit[now.k][now.x][now.y];
			if (now.x == n - 1 && now.y == m - 1) {
				ans = d;
				return;
			}
			if (now.k < k) {
				for (int i = 0; i < 8; i++) {
					int nx = now.x + hx[i];
					int ny = now.y + hy[i];
					if (isOut(nx, ny))
						continue;
					if (visit[now.k + 1][nx][ny] != 0)
						continue;
					visit[now.k + 1][nx][ny] = d + 1;
					q.add(new Pos(now.k + 1, nx, ny));
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (isOut(nx, ny))
					continue;
				if (visit[now.k][nx][ny] != 0)
					continue;
				visit[now.k][nx][ny] = d + 1;
				q.add(new Pos(now.k, nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer to = new StringTokenizer(br.readLine());

		k = Integer.parseInt(to.nextToken());

		to = new StringTokenizer(br.readLine());
		m = Integer.parseInt(to.nextToken());
		n = Integer.parseInt(to.nextToken());

		board = new int[n][m];
		visit = new int[k + 1][n][m];
		for (int i = 0; i < n; i++) {
			to = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(to.nextToken());
			}
		}

		visit[0][0][0] = 1;
		solve();
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans - 1);

	}
}