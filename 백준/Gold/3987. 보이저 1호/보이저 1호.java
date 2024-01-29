import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, sx, sy, curD;
	static final int MAX_VALUE = 500000;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[] d = { 'U', 'R', 'D', 'L' };
	static char[][] board;

	static int slash(int x) {
		if (x == 0)
			return 1;
		if (x == 1)
			return 0;
		if (x == 2)
			return 3;
		else
			return 2;
	}

	static int reverseSlash(int x) {
		if (x == 0)
			return 3;
		if (x == 1)
			return 2;
		if (x == 2)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = bufferedReader.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		sx = Integer.parseInt(stringTokenizer.nextToken());
		sy = Integer.parseInt(stringTokenizer.nextToken());
		int ans = 0;
		char ansD = '0';
		for (int i = 3; i >= 0; i--) {
			curD = i;
			int x = sx - 1;
			int y = sy - 1;
			int count = 1;
			while (true) {
				x += dx[curD];
				y += dy[curD];
				// 종료 조건
				if (x < 0 || x == n || y == m || y < 0 || board[x][y] == 'C')
					break;
				if (count > MAX_VALUE)
					break;
				count++;
				if (board[x][y] == '/') {
					curD = slash(curD);
				}
				if (board[x][y] == '\\') {
					curD = reverseSlash(curD);
				}
			}
			if (ans <= count) {
				ans = count;
				ansD = d[i];
			}
		}
		System.out.println(ansD);
		if (ans >= MAX_VALUE)
			System.out.println("Voyager");
		else
			System.out.println(ans);
	}
}