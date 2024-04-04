import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int t, n;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[][] board;

	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int time;

		public Pos(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			board = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = str.charAt(j) - '0';
				}
			}

			sb.append("#").append(tc).append(" ").append(solve()).append("\n");
		}
		System.out.println(sb);
	}

	static int solve() {
		int[][] time = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(time[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(0, 0, 0));

		while (!pq.isEmpty()) {
			Pos now = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (time[nx][ny] > board[nx][ny] + now.time) {
					time[nx][ny] = board[nx][ny] + now.time;
					pq.add(new Pos(nx, ny, time[nx][ny]));
				}
			}
		}

		return time[n - 1][n - 1];
	}

}