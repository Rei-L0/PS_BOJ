import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, r;

	static long[] factorial = new long[1000001];
	static final long M = 1234567891;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		facto();
		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			long bottom = (factorial[n - r] * factorial[r]) % M;
			long b = solve(bottom, M - 2);
			long ans = (factorial[n] * b) % M;

			sb.append("#").append(tc + " ").append(ans + "\n");
		}
		System.out.println(sb);

	}

	static long solve(long x, long y) {
		if (y == 0)
			return 1;
		else if (y == 1)
			return x;
		if (y % 2 == 0) {
			long tmp = solve(x, y / 2);
			return (tmp * tmp) % M;
		}
		long tmp = solve(x, y - 1);
		return (tmp * x) % M;
	}

	static void facto() {
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1] * i) % M;
		}
	}

}