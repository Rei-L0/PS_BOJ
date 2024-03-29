import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int r, c, ans;

	static Map<Character, Integer> dir = new HashMap<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static char[][] board;
	static boolean[][] check;

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

		dir.put('U', 0);
		dir.put('D', 1);
		dir.put('L', 2);
		dir.put('R', 3);

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		check = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!check[i][j]) {
					ans++;
					check[i][j] = true;
					find(new Pos(i, j));
				}
			}
		}

		System.out.println(ans);

	}

	static void find(Pos pos) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(pos);

		while (!q.isEmpty()) {
			Pos now = q.poll();
			int d = dir.get(board[now.x][now.y]);
			int nx = now.x + dx[d];
			int ny = now.y + dy[d];
			if (!(nx < 0 || ny < 0 || nx >= r || ny >= c || check[nx][ny])) {
				q.add(new Pos(nx, ny));
				check[nx][ny] = true;
			}
			for (int i = 0; i < 4; i++) {
				if (i == d)
					continue;
				if (i == 0) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (check[nx][ny])
						continue;
					if (board[nx][ny] == 'D') {
						q.add(new Pos(nx, ny));
						check[nx][ny] = true;
					}
				}
				if (i == 1) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (check[nx][ny])
						continue;
					if (board[nx][ny] == 'U') {
						q.add(new Pos(nx, ny));
						check[nx][ny] = true;
					}
				}
				if (i == 2) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (check[nx][ny])
						continue;
					if (board[nx][ny] == 'R') {
						q.add(new Pos(nx, ny));
						check[nx][ny] = true;
					}
				}
				if (i == 3) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (check[nx][ny])
						continue;
					if (board[nx][ny] == 'L') {
						q.add(new Pos(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
		}
	}
}