import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int t, n, ans;

	static boolean[] check, finish;
	static int[] num;

	static void solve(int x) {
		check[x] = true;

		int next = num[x];
		if (!check[next])
			solve(next);
		else {
			if (!finish[next]) {
				ans--;
				while (next != x) {
					next = num[next];
					ans--;
				}
			}
		}
		finish[x] = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			ans = n;
			num = new int[n + 1];
			check = new boolean[n + 1];
			finish = new boolean[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n + 1; i++)
				num[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < n + 1; i++) {
				if (!check[i]) {
					solve(i);
				}
			}

			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}