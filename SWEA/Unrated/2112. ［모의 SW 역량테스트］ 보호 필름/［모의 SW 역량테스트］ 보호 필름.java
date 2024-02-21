import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, m, k, ans;
	static int[][] board;

	static BufferedReader bReader;
	static StringTokenizer st;

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		ans = n;
		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(bReader.readLine());
			for (int y = 0; y < m; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
	}

	// 약품 조합
	static void combi(int count, int start, int end, int[] arr, int[] num) {
		if (count == end) {
			// 성능 검사 실행
			solve(arr, num);
			return;
		}
		for (int i = start; i < n; i++) {
			arr[count] = i;
			num[count] = 0;
			combi(count + 1, i + 1, end, arr, num);
			num[count] = 1;
			combi(count + 1, i + 1, end, arr, num);
		}
	}

	// 모든 열이 같은 숫자 연속 k개 이상일 경우 성공
	static void solve(int[] arr, int[] num) {
		// 배열 초기화
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = board[i][j];
			}
		}

		// 약품 투입
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < m; j++) {
				map[arr[i]][j] = num[i];
			}
		}

		if (isAC(map))
			ans = arr.length;

	}

	static boolean isAC(int[][] arr) {
		for (int j = 0; j < m; j++) {
			boolean check = false;
			int now = arr[0][j];
			int count = 1;
			for (int i = 1; i < n; i++) {
				if (now == arr[i][j]) {
					count++;
				} else {
					now = arr[i][j];
					count = 1;
				}
				if (count >= k) {
					check = true;
					break;
				}
			}
			if (!check)
				return false;
		}
		return true;
	}

	// 0부터 n까지 약품 개수를 조정하면서 성능 검사 실행
	// n개의 층 중 약품 개수를 조합으로 생성
	// 성공시 끝
	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			init();
			for (int i = 0; i <= n; i++) {
				combi(0, 0, i, new int[i], new int[i]);
				if (ans != n)
					break;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}