import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;

	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if (i < n - 2 && num[i + 1] > num[i + 2]) {
				if (num[i] > 0 && num[i + 1] > 0) {
					int cnt = Math.min(num[i], num[i + 1] - num[i + 2]);
					for (int j = i; j < i + 2; j++) {
						num[j] -= cnt;
					}
					ans += cnt * 5;
				}
				if (num[i] > 0 && num[i + 1] > 0 && num[i + 2] > 0) {
					int cnt = Math.min(num[i], Math.min(num[i + 1], num[i + 2]));
					for (int j = i; j < i + 3; j++) {
						num[j] -= cnt;
					}
					ans += cnt * 7;
				}
				if (num[i] > 0) {
					ans += num[i] * 3;
					num[i] = 0;
				}
			} else {
				if (i < n - 2) {
					if (num[i] > 0 && num[i + 1] > 0 && num[i + 2] > 0) {
						int cnt = Math.min(num[i], Math.min(num[i + 1], num[i + 2]));
						for (int j = i; j < i + 3; j++) {
							num[j] -= cnt;
						}
						ans += cnt * 7;
					}
				}
				if (i < n - 1) {
					if (num[i] > 0 && num[i + 1] > 0) {
						int cnt = Math.min(num[i], num[i + 1]);
						for (int j = i; j < i + 2; j++) {
							num[j] -= cnt;
						}
						ans += cnt * 5;
					}
				}
				if (num[i] > 0) {
					ans += num[i] * 3;
					num[i] = 0;
				}
			}
		}

		System.out.println(ans);
	}

}