import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int t, w, h, sx, sy, ans;

	static Queue<Pos> fireQ;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] board;
	static int[][] map;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int z = 0; z < t; z++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			ans = 0;

			fireQ = new ArrayDeque<>();
			board = new char[h][w];
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				Arrays.fill(map[i], -1);
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					board[i][j] = s.charAt(j);
					if (board[i][j] == '@') {
						sx = i;
						sy = j;
					}
					if (board[i][j] == '*') {
						fireQ.add(new Pos(i, j));
						map[i][j] = -2;
					}
				}
			}
			sb.append((solve() == -1) ? "IMPOSSIBLE" : ans).append("\n");
		}
		System.out.println(sb);
	}

	static int solve() {
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(sx, sy));
		map[sx][sy] = 0;

		while (true) {
			fireQ = bfs(fireQ, true);
			q = bfs(q, false);
			if (ans != 0) {
				return ans;
			}
			if (q.size() == 0) {
				return -1;
			}
		}
	}

	static Queue<Pos> bfs(Queue<Pos> q, boolean isFire) {
		Queue<Pos> nextQ = new ArrayDeque<>();
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
					if (!isFire) {
						ans = map[now.x][now.y] + 1;
						return null;
					}
					continue;
				}
				if (board[nx][ny] == '#')
					continue;
				if (map[nx][ny] == -1) {
					if (isFire) {
						map[nx][ny] = -2;
					} else {
						map[nx][ny] = map[now.x][now.y] + 1;
					}
					nextQ.add(new Pos(nx, ny));
				}
			}
		}
		return nextQ;
	}
}