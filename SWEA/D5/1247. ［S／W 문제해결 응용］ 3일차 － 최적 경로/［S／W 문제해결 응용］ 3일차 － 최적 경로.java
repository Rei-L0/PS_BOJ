import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, ans, n, hx, hy, sx, sy;
	static int[][] pos;

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void init() throws Exception {
		ans = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		hx = Integer.parseInt(st.nextToken());
		hy = Integer.parseInt(st.nextToken());

		pos = new int[n][2];
		for (int i = 0; i < n; i++) {
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve(int x, int y, int count, int res, boolean[] visit) {
		if (count == n) {
			ans = Math.min(ans, res + calc(x, y, hx, hy));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			int dis = calc(x, y, pos[i][0], pos[i][1]);
			solve(pos[i][0], pos[i][1], count + 1, res + dis, visit);
			visit[i] = false;
		}
	}

	static int calc(int x, int y, int nx, int ny) {
		return Math.abs(x - nx) + Math.abs(y - ny);
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			init();
			solve(sx, sy, 0, 0, new boolean[n]);
			System.out.println("#" + tc + " " + ans);
		}
	}
}