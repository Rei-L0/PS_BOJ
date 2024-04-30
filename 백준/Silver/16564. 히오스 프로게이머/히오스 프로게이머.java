import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 2_000_000_000;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] level = new int[n];
		for (int i = 0; i < n; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(binarySearch(-1, MAX, k, level));
	}

	static long binarySearch(long lo, long hi, int k, int[] arr) {
		long mid = 0;
		while (lo + 1 < hi) {
			mid = (lo + hi) / 2;
			if (check(arr, mid, k)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}

		return lo;
	}

	static boolean check(int[] arr, long mid, int k) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < mid)
				sum += (mid - arr[i]);
		}
		return sum <= k;
	}

}