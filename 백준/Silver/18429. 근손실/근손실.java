import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, k, ans;

	static int[] num;

	static void solve(int count, int weight, boolean[] visit) {
		if (count == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			if (weight + num[i] - k >= 500) {
				visit[i] = true;
				solve(count + 1, weight + num[i] - k, visit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		solve(0, 500, new boolean[n]);

		System.out.println(ans);
	}

}