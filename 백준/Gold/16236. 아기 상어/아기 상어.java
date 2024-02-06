import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, ans, sx, sy, size = 2, count = 0;
	static int[][] board;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Next implements Comparable<Next> {
		int x;
		int y;
		int time;

		public Next(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Next o) {
			if (this.time == o.time) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.time - o.time;
		}
	}

	static boolean eat() {
		PriorityQueue<Next> pq = new PriorityQueue<>();
		ArrayDeque<Next> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new Next(sx, sy, 0));
		visit[sx][sy] = true;

		while (!q.isEmpty()) {
			Next cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx == -1 || nx == n || ny == -1 || ny == n || visit[nx][ny] || board[nx][ny] > size)
					continue;
				if (0 < board[nx][ny] && board[nx][ny] < size) {
					pq.add(new Next(nx, ny, cur.time + 1));
					continue;
				}
				q.add(new Next(nx, ny, cur.time + 1));
				visit[nx][ny] = true;
			}
		}
		if (pq.isEmpty())
			return false;
		else {
			Next res = pq.poll();
			count++;
			ans += res.time;
			sx = res.x;
			sy = res.y;
			board[sx][sy] = 0;
			// 물고기 먹은 후 크기 증가
			if (count == size) {
				count = 0;
				size++;
			}
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					sx = i;
					sy = j;
					board[i][j] = 0;
				}
			}
		}
		boolean isFinish;
		while (true) {
			isFinish = eat();
			if (!isFinish)
				break;
		}
		System.out.println(ans);

	}
}