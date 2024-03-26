import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static int[] num, res, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		res = new int[n];
		num = new int[n];
		arr = new int[n];
		int idx = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		arr[0] = num[0];

		for (int i = 1; i < n; i++) {
			if (num[i] > arr[idx]) {
				arr[++idx] = num[i];
				res[i] = idx;
			} else {
				int k = bs(0, idx, num[i]);
				arr[k] = num[i];
				res[i] = k;
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		System.out.println(idx + 1);
		for (int i = n - 1; i >= 0; i--) {
			if (res[i] == idx) {
				pq.add(num[i]);
				idx--;
			}
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

	static int bs(int s, int e, int v) {
		int mid;
		while (s < e) {
			mid = (s + e) >> 1;
			if (arr[mid] >= v) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return e;
	}

}