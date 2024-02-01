import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[] prime = { 2, 3, 5, 7 };
		for (int i = 0; i < prime.length; i++) {
			appendNumber(prime[i]);
		}
		System.out.print(sb);
	}

	static boolean isPrime(int x) {
		if (x < 2)
			return false;
		for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	static void appendNumber(int x) {
		if (String.valueOf(x).length() == n) {
			sb.append(x).append('\n');
			return;
		}
		for (int i = 0; i < 10; i++) {
			int next = x * 10 + i;
			if (isPrime(next)) {
				appendNumber(next);
			}
		}
	}
}