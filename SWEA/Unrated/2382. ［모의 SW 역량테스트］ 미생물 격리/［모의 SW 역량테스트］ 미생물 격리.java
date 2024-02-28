import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, m, k, ans;

	static HashMap<Integer, Mi> map;

	// 제자리, 상, 하, 좌, 우
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Mi implements Comparable<Mi> {
		int num;
		int x;
		int y;
		int cnt;
		int d;

		public Mi(int num, int x, int y, int cnt, int d) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Mi [num=" + num + ", x=" + x + ", y=" + y + ", cnt=" + cnt + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Mi o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ans = 0;

		map = new HashMap<>();
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(bReader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map.put(i, new Mi(i, x, y, cnt, d));
		}
	}

	// 이동 후 미생물 저장
	static void solve() {
		ArrayList<Mi>[][] check = new ArrayList[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check[i][j] = new ArrayList<>();
			}
		}
		for (int i = 1; i <= k; i++) {
			if (!map.containsKey(i))
				continue;
			Mi cur = map.get(i);
			int nx = cur.x + dx[cur.d];
			int ny = cur.y + dy[cur.d];

			// 약품 만났을 때 이동 후 다음 미생물로
			if (nx == 0 || ny == 0 || nx == n - 1 || ny == n - 1) {
				// 미생물이 0마리일 경우 제거
				if (cur.cnt / 2 == 0) {
					map.remove(i);
					continue;
				}
				map.put(i, new Mi(i, nx, ny, cur.cnt / 2, wall(cur.d)));
				continue;
			}
			map.put(i, new Mi(i, nx, ny, cur.cnt, cur.d));
			check[nx][ny].add(map.get(i));
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j].size() <= 1)
					continue;
				Collections.sort(check[i][j]);
				Mi max = check[i][j].get(0);
				int cnt = max.cnt;
				for (Mi x : check[i][j]) {
					if (max.num == x.num)
						continue;
					cnt += x.cnt;
					map.remove(x.num);
				}
				map.put(max.num, new Mi(max.num, max.x, max.y, cnt, max.d));
			}
		}
	}

	// 약품 만나면 방향 반대로
	static int wall(int x) {
		if (x == 1)
			return 2;
		if (x == 2)
			return 1;
		if (x == 3)
			return 4;
		return 3;
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			init();

			while (m != 0) {
				m--;
				solve();
			}

			for (int i = 1; i <= k; i++) {
				if (map.containsKey(i))
					ans += map.get(i).cnt;
			}

			System.out.println("#" + tc + " " + ans);
		}

	}
}