import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MOD = 1_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(st.nextToken());

		System.out.println(fibo(n));
	}

	static long fibo(long n) {
		if (n == 0)
			return 0;
		long[][] f = { { 1, 1 }, { 1, 0 } };
		pow(f, n - 1);
		return f[0][0];
	}

	static void pow(long[][] f, long n) {
		if (n == 0 || n == 1)
			return;
		long[][] m = { { 1, 1 }, { 1, 0 } };
		pow(f, n / 2);
		multi(f, f);
		if (n % 2 != 0)
			multi(f, m);
	}

	static void multi(long[][] F, long[][] M) {
		long x = (F[0][0] * M[0][0] + F[0][1] * M[1][0]) % MOD;
		long y = (F[0][0] * M[0][1] + F[0][1] * M[1][1]) % MOD;
		long z = (F[1][0] * M[0][0] + F[1][1] * M[1][0]) % MOD;
		long w = (F[1][0] * M[0][1] + F[1][1] * M[1][1]) % MOD;

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;

	}
}