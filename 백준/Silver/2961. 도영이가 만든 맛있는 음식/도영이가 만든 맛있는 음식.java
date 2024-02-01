import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] ta1;
	static int[] ta2;
	static long ans = 1000000000;

	static void back(boolean[] visit, int count, int start, int goal) {
		if (count == goal) {
			int s = 1;
			int b = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					s *= ta1[i];
					b += ta2[i];
				}
			}
			ans = Math.min(ans, (int) Math.abs(s - b));
			return;
		}
		for (int i = start; i < n; i++) {
			visit[i] = true;
			back(visit, count + 1, i + 1, goal);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());

		ta1 = new int[n];
		ta2 = new int[n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			ta1[i] = Integer.parseInt(stringTokenizer.nextToken());
			ta2[i] = Integer.parseInt(stringTokenizer.nextToken());

		}
		for (int i = 1; i < n + 1; i++) {
			back(new boolean[n], 0, 0, i);
		}
		System.out.println(ans);
	}

}