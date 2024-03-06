import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int r, c, sx, sy, fx, fy, ans;

	static final char Wall = '#';
	static ArrayDeque<Pos> fire = new ArrayDeque<>();

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] map;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static boolean solve() {
		int[][] board = new int[r][c];
		boolean[][] fireBoard = new boolean[r][c];

		ArrayDeque<Pos> ji = new ArrayDeque<>();

		ji.add(new Pos(sx, sy));
		board[sx][sy] = 1;

		int time = 0;
		while (true) {
			time++;
			int fireSize = fire.size();
			for (int j = 0; j < fireSize; j++) {
				Pos now = fire.poll();
				fireBoard[now.x][now.y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (map[nx][ny] == Wall || fireBoard[nx][ny])
						continue;
					fire.add(new Pos(nx, ny));
					fireBoard[nx][ny] = true;
				}
			}
			int moveSize = ji.size();
			if (moveSize == 0)
				return false;
			for (int j = 0; j < moveSize; j++) {
				Pos now = ji.poll();
				if (now.x == 0 || now.x == (r - 1) || now.y == 0 || now.y == (c - 1)) {
					ans = board[now.x][now.y];
					return true;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (map[nx][ny] == Wall || fireBoard[nx][ny] || board[nx][ny] != 0)
						continue;
					ji.add(new Pos(nx, ny));
					board[nx][ny] = board[now.x][now.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					sx = i;
					sy = j;
				}
				if (map[i][j] == 'F') {
					fire.add(new Pos(i, j));
				}
			}
		}

		if (solve())
			System.out.println(ans);
		else
			System.out.println("IMPOSSIBLE");

	}
}