import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static int[] num, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		num = new int[n];
		res = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		int next = 1;
		res[size] = num[0];

		while (next != n) {
			if (num[next] > res[size]) {
				size++;
				res[size] = num[next];
			} else {
				int idx = bs(-1, size, num[next]);
				res[idx] = num[next];
			}
			next++;
		}
		System.out.println(size + 1);
	}

	static int bs(int lo, int hi, int val) {
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (res[mid] < val) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

}