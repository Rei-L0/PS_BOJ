// 12100
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static final int MOVE = 5;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	// 오른쪽
	static void right(int count, int[][] arr2) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			// 값 추출
			for (int j = n - 1; j >= 0; j--) {
				if (arr[i][j] != 0)
					q.add(arr[i][j]);
			}
			for (int j = n - 1; j >= 0; j--) {
				if (q.isEmpty())
					arr[i][j] = 0;
				else {
					int x = q.poll();
					if (q.isEmpty()) {
						arr[i][j] = x;
						continue;
					}
					if (x == q.peek())
						arr[i][j] = x + q.poll();
					else
						arr[i][j] = x;
				}
			}
		}
		if (count == MOVE) {
			solve(arr);
			return;
		}
		right(count + 1, arr);
		left(count + 1, arr);
		up(count + 1, arr);
		down(count + 1, arr);
	}

	// 왼쪽
	static void left(int count, int[][] arr2) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			// 값 추출
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0)
					q.add(arr[i][j]);
			}
			for (int j = 0; j < n; j++) {
				if (q.isEmpty())
					arr[i][j] = 0;
				else {
					int x = q.poll();
					if (q.isEmpty()) {
						arr[i][j] = x;
						continue;
					}
					if (x == q.peek())
						arr[i][j] = x + q.poll();
					else
						arr[i][j] = x;
				}
			}
		}
		if (count == MOVE) {
			solve(arr);
			return;
		}
		right(count + 1, arr);
		left(count + 1, arr);
		up(count + 1, arr);
		down(count + 1, arr);
	}

	// 위
	static void up(int count, int[][] arr2) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		for (int j = 0; j < n; j++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			// 값 추출
			for (int i = 0; i < n; i++) {
				if (arr[i][j] != 0)
					q.add(arr[i][j]);
			}
			for (int i = 0; i < n; i++) {
				if (q.isEmpty())
					arr[i][j] = 0;
				else {
					int x = q.poll();
					if (q.isEmpty()) {
						arr[i][j] = x;
						continue;
					}
					if (x == q.peek())
						arr[i][j] = x + q.poll();
					else
						arr[i][j] = x;
				}
			}
		}
		if (count == MOVE) {
			solve(arr);
			return;
		}
		left(count + 1, arr);
		right(count + 1, arr);
		up(count + 1, arr);
		down(count + 1, arr);
	}

	// 아래
	static void down(int count, int[][] arr2) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		for (int j = 0; j < n; j++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			// 값 추출
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i][j] != 0)
					q.add(arr[i][j]);
			}
			for (int i = n - 1; i >= 0; i--) {
				if (q.isEmpty())
					arr[i][j] = 0;
				else {
					int x = q.poll();
					if (q.isEmpty()) {
						arr[i][j] = x;
						continue;
					}
					if (x == q.peek())
						arr[i][j] = x + q.poll();
					else
						arr[i][j] = x;
				}
			}
		}
		if (count == MOVE) {
			solve(arr);
			return;
		}
		right(count + 1, arr);
		left(count + 1, arr);
		up(count + 1, arr);
		down(count + 1, arr);
	}

	static void solve(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0)
					pq.add(arr[i][j]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		right(1, board);
		down(1, board);
		up(1, board);
		left(1, board);

		System.out.println(pq.poll());

	}
}