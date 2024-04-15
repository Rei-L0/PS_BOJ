import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, v, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			if (num[i] == v)
				ans++;
		}
		System.out.println(ans);
	}
}