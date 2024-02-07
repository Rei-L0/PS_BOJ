import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static int[][] board;
	static int[] oper;

	static void solve(int x) {
		if (x == 1)
			oper1();
		else if (x == 2)
			oper2();
		else if (x == 3)
			oper3();
		else if (x == 4)
			oper4();
		else if (x == 5)
			oper5();
		else if (x == 6)
			oper6();
	}

	static void oper1() {
		for (int i = 0; i < board.length / 2; i++) {
			int[] tmp = board[i];
			board[i] = board[board.length - i - 1];
			board[board.length - i - 1] = tmp;
		}
	}

	static void oper2() {
		for (int i = 0; i < board[0].length / 2; i++) {
			for (int j = 0; j < board.length; j++) {
				int tmp = board[j][i];
				board[j][i] = board[j][board[0].length - i - 1];
				board[j][board[0].length - i - 1] = tmp;
			}
		}
	}

	static void oper3() {
		int[][] tmp = new int[board[0].length][board.length];
		int row = 0;
		for (int j = 0; j < board[0].length; j++) {
			int col = 0;
			for (int i = board.length - 1; i >= 0; i--) {
				tmp[row][col++] = board[i][j];
			}
			row++;
		}
		Arrays.copyOf(board, board[0].length);
		board = tmp;
	}

	static void oper4() {
		int[][] tmp = new int[board[0].length][board.length];
		int row = 0;
		for (int j = board[0].length - 1; j >= 0; j--) {
			int col = 0;
			for (int i = board.length - 1; i >= 0; i--) {
				tmp[row][col++] = board[i][j];
			}
			row++;
		}
		Arrays.copyOf(board, board[0].length);
		board = tmp;
		oper2();
	}

	static void oper5() {
		int row = board.length / 2;
		int col = board[0].length / 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int tmp = board[i][j + col];
				board[i][j + col] = board[i][j];
				int tmp2 = board[i + row][j + col];
				board[i + row][j + col] = tmp;
				tmp = board[i + row][j];
				board[i + row][j] = tmp2;
				board[i][j] = tmp;
			}
		}
	}

	static void oper6() {
		int row = board.length / 2;
		int col = board[0].length / 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int tmp = board[i + row][j];
				board[i + row][j] = board[i][j];
				int tmp2 = board[i + row][j + col];
				board[i + row][j + col] = tmp;
				tmp = board[i][j + col];
				board[i][j + col] = tmp2;
				board[i][j] = tmp;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++)
			solve(Integer.parseInt(st.nextToken()));

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}