import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int n, m, time, count;
	static int[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static ArrayDeque<Pos> solve() {
		ArrayDeque<Pos> resQ = new ArrayDeque<>();
		ArrayDeque<Pos> findQ = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];
		findQ.add(new Pos(0, 0));
		while (!findQ.isEmpty()) {
			Pos now = findQ.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx == -1 || ny == -1 || nx == n || ny == m || visit[nx][ny])
					continue;
				if (board[nx][ny] == 0) {
					findQ.add(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
				if (board[nx][ny] == 1) {
					resQ.add(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
			}

		}
		return resQ;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayDeque<Pos> q;

		while (true) {
			q = solve();
			if (q.size() == 0) {
				System.out.println(time);
				System.out.println(count);
				break;
			}
			time++;
			count = q.size();
			while (!q.isEmpty()) {
				Pos now = q.poll();
				board[now.x][now.y] = 0;
			}
		}
	}
}