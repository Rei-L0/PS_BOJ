import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, p;

	static Queue<Pos>[] move;

	static int[] s, ans;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] board;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pos {
		int x;
		int y;
		int d;

		public Pos(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		s = new int[p + 1];
		ans = new int[p + 1];
		board = new char[n][m];
		move = new ArrayDeque[p + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < p + 1; i++) {
			s[i] = Integer.parseInt(st.nextToken());
			move[i] = new ArrayDeque<Pos>();
		}

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
				if (Character.isDigit(board[i][j])) {
					int num = board[i][j] - '0';
					move[num].add(new Pos(i, j, 0));
					ans[num]++;
				}
			}
		}

		while (true) {
			int cnt = 0;
			for (int i = 1; i < p + 1; i++) {
				if (!expand(i))
					cnt++;
			}
			if (cnt == p) {
				break;
			}
		}

		for (int i = 1; i < p + 1; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	static boolean expand(int idx) {
		if (move[idx].size() == 0)
			return false;

		Queue<Pos> q = move[idx];
		Queue<Pos> nextQ = new ArrayDeque<>();

		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (board[nx][ny] != '.')
					continue;
				if (now.d != s[idx]) {
					q.add(new Pos(nx, ny, now.d + 1));
				} else {
					nextQ.add(new Pos(now.x, now.y, 0));
					continue;
				}
				board[nx][ny] = (char) (idx + '0');
				ans[idx]++;
			}
		}
		move[idx] = nextQ;
		return true;
	}
}