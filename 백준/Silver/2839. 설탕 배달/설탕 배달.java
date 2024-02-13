import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 5000);

		for (int i = 3; i < n + 1; i++) {
			if (i % 3 == 0) {
				arr[i] = i / 3;
			}
			if (i % 5 == 0) {
				arr[i] = i / 5;
			}
			if (i > 4)
				arr[i] = Math.min(arr[i - 5] + 1, arr[i]);
			arr[i] = Math.min(arr[i], arr[i - 3] + 1);
		}

		if (arr[n] == 5000)
			System.out.println(-1);
		else
			System.out.println(arr[n]);

	}
}