import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long ans;

	static int[] num;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());

		num = new int[n + 1];
		check = new boolean[(int) Math.pow(10, 6) + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++)
			num[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;

		while (end != n) {
			if (check[num[end + 1]]) {
				while (check[num[end + 1]]) {
					start += 1;
					check[num[start]] = false;
				}
			}
			end += 1;
			check[num[end]] = true;
			ans += (end - start);
		}

		System.out.println(ans);

	}
}