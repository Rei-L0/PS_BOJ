import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int ans, ansCount, n;
	static int[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Core> coreList;

	static class Core {

		int x;
		int y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void solve(int idx, int d, int count, int coreCount, int[][] arr) {
		if (idx == coreList.size()) {
			if (ansCount < coreCount) {
				ansCount = coreCount;
				ans = count;
			} else if (ansCount == coreCount) {
				ans = Math.min(count, ans);
			}
			return;
		}

		if (d == 4) {
			solve(idx + 1, 0, count, coreCount, arr);
			return;
		}

		solve(idx, d + 1, count, coreCount, arr);

		int[][] curArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			curArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}

		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;

		int lineCount = 0;

		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (check(nx, ny)) {
				solve(idx + 1, 0, count + lineCount, coreCount + 1, curArr);
				return;
			}
			if (curArr[nx][ny] == 1) {
				return;
			}
			lineCount++;
			curArr[nx][ny] = 1;
			x = nx;
			y = ny;
		}
	}

	static boolean check(int x, int y) {
		return (x == -1 || y == -1 || x == n || y == n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bReader.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(bReader.readLine());
			n = Integer.parseInt(st.nextToken());

			ans = Integer.MAX_VALUE;
			ansCount = 0;
			int coreCount = 0;
			board = new int[n][n];
			coreList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bReader.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리가 아닐 경우 core list 에 삽입
					if (board[i][j] == 1) {
						if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
							coreCount++;
							continue;
						}
						coreList.add(new Core(i, j));
					}
				}
			}
			solve(0, 0, 0, coreCount, board);
			System.out.println("#" + tc + " " + ans);
		}

	}
}