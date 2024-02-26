import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int t, n, k, x;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] cup = new int[n + 1];

		for (int i = 1; i < n + 1; i++)
			cup[i] = i;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int tmp = cup[s];
			cup[s] = cup[e];
			cup[e] = tmp;
		}
		int ans = 0;
		for (int i = 1; i < n + 1; i++) {
			if (cup[i] == x) {
				ans = i;
			}
		}
		System.out.println(ans);
	}

}