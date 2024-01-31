import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer stringTokenizer;
	static int n, m;
	static int[][] num;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		num = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j < n + 1; j++) {
				num[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				num[i][j] += num[i][j - 1];
			}
		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int sx = Integer.parseInt(stringTokenizer.nextToken());
			int sy = Integer.parseInt(stringTokenizer.nextToken());
			int ex = Integer.parseInt(stringTokenizer.nextToken());
			int ey = Integer.parseInt(stringTokenizer.nextToken());
			int ans = 0;
			for (int j = sx; j <= ex; j++) {
				ans += num[j][ey] - num[j][sy - 1];
			}
			stringBuilder.append(ans).append('\n');
		}
		System.out.print(stringBuilder);
	}

}