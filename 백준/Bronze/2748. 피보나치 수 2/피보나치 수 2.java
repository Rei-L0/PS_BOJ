import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;

	static BigInteger[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		dp = new BigInteger[n + 1];

		for (int i = 1; i < n + 1; i++) {
			if (i == 1 || i == 2) {
				dp[i] = new BigInteger("1");
			} else {
				dp[i] = dp[i - 1].add(dp[i - 2]);
			}
		}

		System.out.println(dp[n]);
	}
}