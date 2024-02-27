import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 등산로 조성
public class Solution {

	static int t, n, maxVal, k, ans;

	static int[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static ArrayList<Pos> top;

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		top = new ArrayList<>();
		maxVal = 0;
		ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bReader.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (maxVal < board[i][j])
					maxVal = board[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (maxVal == board[i][j])
					top.add(new Pos(i, j));
			}
		}

	}

	static void solve(int x, int y, int num, int count, boolean cut, boolean[][] visit) {
		ans = Math.max(count, ans);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx == -1 || ny == -1 || nx == n || ny == n || visit[nx][ny])
				continue;
			if (board[nx][ny] < num) {
				visit[nx][ny] = true;
				solve(nx, ny, board[nx][ny], count + 1, cut, visit);
				visit[nx][ny] = false;
			} else {
				if (cut)
					continue;
				if (num > board[nx][ny] - k) {
					visit[nx][ny] = true;
					solve(nx, ny, num - 1, count + 1, true, visit);
					visit[nx][ny] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			init();

			boolean[][] visit = new boolean[n][n];
			for (Pos i : top) {
				visit[i.x][i.y] = true;
				solve(i.x, i.y, maxVal, 1, false, visit);
				visit[i.x][i.y] = false;
			}

			System.out.println("#" + tc + " " + ans);
		}

	}
}