import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static final int SIZE = 9;
	static int[][] board;
	static ArrayList<Pos> list = new ArrayList<>();

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	// 백트래킹 시작
	static void solve(int count) {
		if (count == list.size()) {
			for (int x = 0; x < SIZE; x++) {
				for (int y = 0; y < SIZE; y++) {
					System.out.print(board[x][y]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		for (int i = 1; i < 10; i++) {
			Pos now = list.get(count);
			board[now.x][now.y] = i;
			if (!checkCol(now.x) || !checkRow(now.y) || !checkRect()) {
				board[now.x][now.y] = 0;
				continue;
			}
			solve(count + 1);
			board[now.x][now.y] = 0;
		}
	}

	static boolean checkRow(int y) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < SIZE; i++) {
			if (board[i][y] == 0)
				continue;
			if (check[board[i][y]])
				return false;
			check[board[i][y]] = true;
		}
		return true;

	}

	static boolean checkCol(int x) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < SIZE; i++) {
			if (board[x][i] == 0)
				continue;
			if (check[board[x][i]])
				return false;
			check[board[x][i]] = true;
		}
		return true;
	}

	static boolean checkRect() {
		for (int i = 0; i < SIZE; i = i + 3) {
			for (int j = 0; j < SIZE; j = j + 3) {
				boolean[] check = new boolean[10];
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (board[i + x][j + y] == 0)
							continue;
						if (check[board[i + x][j + y]])
							return false;
						check[board[i + x][j + y]] = true;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		board = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			String string = br.readLine();
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = (int) (string.charAt(j) - '0');
				if (board[i][j] == 0)
					list.add(new Pos(i, j));
			}
		}
		solve(0);
	}
}