import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static int[] num, arr;

	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num = new int[n];
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			arr[i] = num[i];
		}

		Arrays.sort(arr);

		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], idx);
				idx++;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(map.get(num[i])).append(" ");
		}
		System.out.println(sb);

	}
}