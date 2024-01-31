import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		combi(new int[m], 0, 1);
	}

	// 조합
	private static void combi(int[] numbers, int cnt, int start) {
		if (cnt == m) {
			for (int i : numbers)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for (int i = start; i <= n; i++) {
			numbers[cnt] = i;
			combi(numbers, cnt + 1, i + 1);
		}
	}
}