import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, sx, sy, ex, ey;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder sBuilder = new StringBuilder();
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		board = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j < m + 1; j++) {
				board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if (j != 0)
					board[i][j] += board[i][j - 1];
			}
		}
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		k = Integer.parseInt(stringTokenizer.nextToken());
		for (int i = 0; i < k; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			sx = Integer.parseInt(stringTokenizer.nextToken());
			sy = Integer.parseInt(stringTokenizer.nextToken());
			ex = Integer.parseInt(stringTokenizer.nextToken());
			ey = Integer.parseInt(stringTokenizer.nextToken());
			int ans = 0;
			for (int j = sx; j <= ex; j++) {
				ans += (board[j][ey] - board[j][sy - 1]);
			}
			sBuilder.append(ans).append("\n");
		}
		System.out.print(sBuilder);
	}
}