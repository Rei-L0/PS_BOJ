import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long n;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

		n = Long.parseLong(st.nextToken());

		long start = 0;
		long end = (long) Math.sqrt(n);

		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid < n)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(start);
	}
}