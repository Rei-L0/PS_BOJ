import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	static int t, h, w, n, x, y;
	static char[][] board;
	static String oper;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[] tank = { '^', 'v', '<', '>' };
	static HashMap<Character, Integer> map = new HashMap<>();

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		board = new char[h][w];
		for (int i = 0; i < h; i++) {
			String string = br.readLine();
			for (int j = 0; j < w; j++) {
				board[i][j] = string.charAt(j);
				for (int k = 0; k < 4; k++) {
					if (board[i][j] == tank[k]) {
						x = i;
						y = j;
						break;
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		oper = br.readLine();
	}

	static void solve(char op) {
		if (op == 'S') {
			int i = 0;
			for (int k = 0; k < 4; k++) {
				if (board[x][y] == tank[k]) {
					i = k;
					break;
				}
			}
			int px = x;
			int py = y;
			while (true) {
				px += dx[i];
				py += dy[i];
				if (px == -1 || px == h || py == -1 || py == w)
					return;
				if (board[px][py] == '#')
					return;
				if (board[px][py] == '*') {
					board[px][py] = '.';
					return;
				}
			}
		} else {
			int i = map.get(op);
			board[x][y] = tank[i];
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (-1 < nx && nx < h && -1 < ny && ny < w) {
				if (board[nx][ny] == '.') {
					board[nx][ny] = board[x][y];
					board[x][y] = '.';
					x = nx;
					y = ny;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());

		map.put('U', 0);
		map.put('D', 1);
		map.put('L', 2);
		map.put('R', 3);

		for (int tc = 1; tc <= t; tc++) {
			init();
			for (int i = 0; i < n; i++) {
				solve(oper.charAt(i));
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
	}

}