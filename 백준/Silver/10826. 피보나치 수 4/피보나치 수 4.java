import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static BigInteger[] fibo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		fibo = new BigInteger[n + 1];

		for (int i = 0; i < n + 1; i++) {
			if (i == 0) {
				fibo[i] = new BigInteger("0");
			} else if (i == 1 || i == 2) {
				fibo[i] = new BigInteger("1");
			} else {
				fibo[i] = fibo[i - 1].add(fibo[i - 2]);
			}
		}

		System.out.println(fibo[n]);

	}

}