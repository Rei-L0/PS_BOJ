import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bufferedReader.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][n];
			int count = 1;
			int x = 0;
			int y = 0;
			int d = 0;
			board[x][y] = count;
			while (count != n * n) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx == n || nx == -1 || ny == n || ny == -1 || board[nx][ny] != 0) {
					d = (d + 1) % 4;
					continue;
				}
				count++;
				board[nx][ny] = count;
				x = nx;
				y = ny;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}