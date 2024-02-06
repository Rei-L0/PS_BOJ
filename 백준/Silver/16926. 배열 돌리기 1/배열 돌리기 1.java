import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void rotate(int num) {
		int cur = board[num][num];
		int tmp = 0;
		int x = num;
		int y = num;
		int i = 0;
		while (true) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx == (num - 1) || ny == (num - 1) || nx == (n - num + 2) || ny == (m - num + 2)) {
				i++;
				continue;
			}
			if (nx == num && ny == num) {
				board[nx][ny] = cur;
				break;
			}
			x = nx;
			y = ny;
			tmp = board[nx][ny];
			board[nx][ny] = cur;
			cur = tmp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		board = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (r != 0) {
			for (int i = 1; i <= (int) Math.min(n / 2, m / 2); i++) {
				rotate(i);
				if (r == 0)
					break;
			}
			r--;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}