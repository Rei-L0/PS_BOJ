import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

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

	static int solve() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		int[][][] map = new int[k + 1][n][m];

		q.add(new Pos(0, 0, 0));
		map[0][0][0] = 1;

		while (!q.isEmpty()) {
			Pos now = q.poll();
			if (now.x == n - 1 && now.y == m - 1)
				return map[now.k][now.x][now.y];
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (board[nx][ny] == 0) {
					if (map[now.k][nx][ny] != 0)
						continue;
					map[now.k][nx][ny] = map[now.k][now.x][now.y] + 1;
					q.add(new Pos(now.k, nx, ny));
				} else {
					if (now.k >= k)
						continue;
					if (map[now.k + 1][nx][ny] != 0)
						continue;
					map[now.k + 1][nx][ny] = map[now.k][now.x][now.y] + 1;
					q.add(new Pos(now.k + 1, nx, ny));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = string.charAt(j) - '0';
			}
		}

		System.out.println(solve());

	}
}