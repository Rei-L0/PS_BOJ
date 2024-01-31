import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer stringTokenizer;
	static int n, m;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		num = new int[n + 1];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i < n + 1; i++) {
			num[i] = Integer.parseInt(stringTokenizer.nextToken());
			num[i] += num[i - 1];
		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int s = Integer.parseInt(stringTokenizer.nextToken());
			int e = Integer.parseInt(stringTokenizer.nextToken());
			stringBuilder.append(num[e] - num[s - 1]).append('\n');
		}
		System.out.print(stringBuilder);
	}
}