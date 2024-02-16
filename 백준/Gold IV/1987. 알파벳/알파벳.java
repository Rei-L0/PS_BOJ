import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans = 1;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] board;

	static void solve(int x, int y, String res) {
		String str = new String();
		str = res;
		for (int i = 0; i < 4; i++) {
			boolean avail = true;
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx == -1 || ny == -1 || nx == n || ny == m)
				continue;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == board[nx][ny]) {
					ans = Math.max(ans, res.length());
					avail = false;
					break;
				}
			}
			if (avail)
				solve(nx, ny, str + board[nx][ny]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = string.charAt(j);
			}
		}
		String str = "";
		solve(0, 0, str + board[0][0]);
		System.out.println(ans);
	}

}