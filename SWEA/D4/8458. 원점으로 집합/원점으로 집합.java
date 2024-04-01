import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, n;

	static int[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			dis = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				dis[i] = Math.abs(x) + Math.abs(y);
			}

			sb.append("#").append(tc + " ").append(solve() + "\n");
		}
		System.out.println(sb);
	}

	static int solve() {
		int time = 0;
		while (!check()) {
			time++;
			for (int i = 0; i < n; i++) {
				if (dis[i] > time) {
					dis[i] -= time;
				} else {
					dis[i] = (time - dis[i]) % 2;
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (dis[i] < 2) {
					cnt++;
				}
			}
			if (cnt == n) {
				if (!avail())
					return -1;
			}
		}
		return time;
	}

	static boolean check() {
		for (int i = 0; i < n; i++) {
			if (dis[i] != 0)
				return false;
		}
		return true;
	}

	static boolean avail() {
		for (int i = 1; i < n; i++) {
			if (dis[i] % 2 != dis[0] % 2) {
				return false;
			}
		}
		return true;
	}

}