import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, x, ans;

	static int[][] board;

	static StringTokenizer st;
	static BufferedReader bReader;

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		ans = 0;
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bReader.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		// 행 기준
		for (int i = 0; i < n; i++) {
			boolean avail = true;
			int now = board[i][0];
			int count = 1;
			for (int j = 1; j < n; j++) {
				if (Math.abs(board[i][j] - now) > 1) {
					avail = false;
					break;
				}
				if (board[i][j] > now) {
					if (count < x) {
						avail = false;
						break;
					}
					now = board[i][j];
					count = 1;
				} else if (board[i][j] < now) {
					int target = board[i][j];
					boolean check = true;
					for (int k = 1; k < x; k++) {
						if (j + k == n) {
							check = false;
							break;
						}
						if (board[i][j + k] != target)
							check = false;

					}
					if (check) {
						j += x - 1;
						now = target;
						count = 0;
					} else {
						avail = false;
						break;
					}
				} else {
					count++;
				}
			}
			if (avail)
				ans++;
		}

		// 열 기준

		for (int i = 0; i < n; i++) {
			boolean avail = true;
			int now = board[0][i];
			int count = 1;
			for (int j = 1; j < n; j++) {
				if (Math.abs(board[j][i] - now) > 1) {
					avail = false;
					break;
				}
				if (board[j][i] > now) {
					if (count < x) {
						avail = false;
						break;
					}
					now = board[j][i];
					count = 1;
				} else if (board[j][i] < now) {
					int target = board[j][i];
					boolean check = true;
					for (int k = 1; k < x; k++) {
						if (j + k == n) {
							check = false;
							break;
						}
						if (board[j + k][i] != target)
							check = false;

					}
					if (check) {
						j += x - 1;
						now = target;
						count = 0;
					} else {
						avail = false;
						break;
					}
				} else {
					count++;
				}
			}
			if (avail)
				ans++;
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine().trim());

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			init();
			solve();
			System.out.println("#" + tc + " " + ans);
		}

	}
}