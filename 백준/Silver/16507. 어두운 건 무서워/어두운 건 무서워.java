import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int r, c, q;

	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		board = new int[r + 1][c + 1];
		for (int i = 1; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] += board[i][j - 1];
			}
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(sum(x1, y1, x2, y2) / ((x2 - x1 + 1) * (y2 - y1 + 1)) + "\n");
		}

		System.out.println(sb);
	}

	static int sum(int x1, int y1, int x2, int y2) {
		int res = 0;
		for (int i = x1; i <= x2; i++) {
			res += (board[i][y2] - board[i][y1 - 1]);
		}
		return res;
	}

}