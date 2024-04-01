import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, t, ans;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[][] map;
	static int[][] air = new int[2][2];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && air[0][0] == 0) {
					air[0][0] = i;
					air[1][0] = i + 1;
					air[0][1] = air[1][1] = j;
				}
			}
		}

		while (t-- > 0) {
			int[][] add = new int[r][c];

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 0)
						continue;
					spread(i, j, add);
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					map[i][j] += add[i][j];
				}
			}

			circulate(air[0], new int[] { 0, -1, 0, 1 }, new int[] { 1, 0, -1, 0 });
			circulate(air[1], new int[] { 0, 1, 0, -1 }, new int[] { 1, 0, -1, 0 });
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}

		System.out.println(ans);

	}

	static void spread(int x, int y, int[][] arr) {
		int cnt = 0;
		int div = map[x][y] / 5;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			if (map[nx][ny] == -1)
				continue;
			cnt++;
			arr[nx][ny] += div;
		}
		arr[x][y] -= div * cnt;
	}

	static void circulate(int[] pos, int[] dx, int[] dy) {
		int x = pos[0];
		int y = pos[1] + 1;
		int i = 0;
		int now = map[x][y];
		int next = 0;
		map[x][y] = 0;

		while (true) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
				i++;
				continue;
			}
			if (map[nx][ny] == -1) {
				return;
			}
			next = map[nx][ny];
			map[nx][ny] = now;
			now = next;
			x = nx;
			y = ny;
		}
	}

}