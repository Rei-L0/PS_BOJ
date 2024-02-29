import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int n, m, index = 1;

	static int[] size;
	static int[][] board, ans;

	static ArrayDeque<Pos> q = new ArrayDeque<>();

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	// 0일 때 탐색한다.
	// 해당 공간의 size를 size 배열에 저장한다.
	static void solve(int x, int y) {
		// 초기값 세팅
		// 해당 map의 사이즈
		int res = 1;
		q.add(new Pos(x, y));
		ans[x][y] = index;

		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				// 나가거나 벽일 때
				if (isOut(nx, ny) || board[nx][ny] == 1)
					continue;
				if (ans[nx][ny] != 0)
					continue;
				q.add(new Pos(nx, ny));
				ans[nx][ny] = index;
				res++;
			}
		}
		size[index] = res;
		index++;
	}

	static boolean isOut(int x, int y) {
		return (x == -1 || y == -1 || x == n || y == m);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		ans = new int[n][m];
		size = new int[(n * m) + 1];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0)
					sb.append(0);
				else {
					int wallSize = 1;
					HashSet<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (isOut(nx, ny))
							continue;
						if (board[nx][ny] == 1)
							continue;
						if (set.contains(ans[nx][ny]))
							continue;
						if (ans[nx][ny] == 0)
							solve(nx, ny);
						set.add(ans[nx][ny]);
						wallSize = (wallSize + size[ans[nx][ny]]) % 10;
					}
					sb.append(wallSize);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}