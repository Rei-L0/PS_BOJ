import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, d, ans;
	static int[][] board;
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { -1, 0, 0, 1 };

	static void combi(int start, int count, int[] pos) {
		if (count == 3) {
			ans = Math.max(ans, solve(pos));
			return;
		}
		for (int i = start; i < m; i++) {
			pos[count] = i;
			combi(i + 1, count + 1, pos);
		}
	}

	static int solve(int[] archer) {
		int dieCount = 0;
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = board[i][j];
			}
		}

		while (!isFinish(arr)) {
			ArrayList<Pos> kill = new ArrayList<>();
			for (int i = 0; i < archer.length; i++) {
				Pos x = attack(arr, archer[i]);
				if (x != null)
					kill.add(x);
			}
			for (int i = 0; i < kill.size(); i++) {
				Pos die = kill.get(i);
				if (arr[die.x][die.y] == 1) {
					dieCount++;
					arr[die.x][die.y] = 0;
				}
			}
			for (int i = 0; i < kill.size(); i++) {
				Pos die = kill.get(i);
				arr[die.x][die.y] = 0;
			}
			move(arr);
		}
		return dieCount;
	}

	static Pos attack(int[][] arr, int archer) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(n, archer, 0));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			if (now.d == d)
				continue;
			for (int j = 0; j < 4; j++) {
				int nx = now.x + dx[j];
				int ny = now.y + dy[j];
				if (nx >= n || ny >= m || nx == -1 || ny == -1)
					continue;
				if (arr[nx][ny] == 1)
					return new Pos(nx, ny, now.d + 1);
				q.add(new Pos(nx, ny, now.d + 1));
			}
		}
		return null;
	}

	static void move(int[][] arr) {
		for (int j = 0; j < m; j++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = n - 2; i >= 0; i--) {
				q.offer(arr[i][j]);
			}
			q.offer(0);
			for (int i = n - 1; i >= 0; i--) {
				arr[i][j] = q.poll();
			}
		}

	}

	static boolean isFinish(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	static class Pos {
		int x;
		int y;
		int d;

		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0, new int[3]);
		System.out.println(ans);
	}

}