import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, k;

	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		int cnt = 0;
		int ans = Integer.MAX_VALUE;

		while (end != (n + 1)) {
			if (cnt < k) {
				if (end == n)
					break;
				if (num[end] == 1) {
					cnt++;
				}
				end++;
			} else {
				ans = Math.min(end - start, ans);
				if (num[start] == 1) {
					cnt--;
				}
				start++;
			}
		}
		System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
	}

}