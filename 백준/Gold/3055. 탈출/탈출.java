import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int r, c, sx, sy, ex, ey;
	static boolean check;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] board;

	static Queue<Pos> waterQ = new ArrayDeque<>();
	static Queue<Pos> goQ = new ArrayDeque<>();

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

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'D') {
					ex = i;
					ey = j;
				} else if (board[i][j] == 'S') {
					goQ.add(new Pos(i, j));
				} else if (board[i][j] == '*') {
					waterQ.add(new Pos(i, j));
				}
			}
		}

		int time = 0;
		while (true) {
			time++;
			waterQ = waterBfs(waterQ);
			goQ = goBfs(goQ);
			if (check) {
				System.out.println(time);
				break;
			}
			if (goQ.size() == 0) {
				System.out.println("KAKTUS");
				break;
			}
		}

	}

	static Queue<Pos> waterBfs(Queue<Pos> q) {
		Queue<Pos> nextQ = new ArrayDeque<>();

		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (board[nx][ny] == '.') {
					nextQ.add(new Pos(nx, ny));
					board[nx][ny] = '*';
				}
			}
		}
		return nextQ;
	}

	static Queue<Pos> goBfs(Queue<Pos> q) {
		Queue<Pos> nextQ = new ArrayDeque<>();

		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (board[nx][ny] == '.') {
					nextQ.add(new Pos(nx, ny));
					board[nx][ny] = '*';
				}
				if (board[nx][ny] == 'D') {
					check = true;
					return null;
				}
			}
		}
		return nextQ;
	}

}