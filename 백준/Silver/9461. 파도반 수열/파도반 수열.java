import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());

		long[] num = new long[101];

		for (int i = 1; i < 101; i++) {
			if (i == 1 || i == 2 || i == 3) {
				num[i] = 1;
			} else if (i == 5 || i == 4) {
				num[i] = 2;
			} else {
				num[i] = num[i - 1] + num[i - 5];
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			sb.append(num[n]).append("\n");
		}

		System.out.println(sb);
	}

}