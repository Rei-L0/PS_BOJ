import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;

	static int bS(int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return 1;
			}
			if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		st = new StringTokenizer(bufferedReader.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			System.out.println(bS(target));
		}
	}
}