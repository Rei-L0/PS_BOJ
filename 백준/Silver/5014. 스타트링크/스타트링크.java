import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int f, s, g, u, d;
	static ArrayDeque<Integer> q = new ArrayDeque<>();

	static void solve(int[] time) {
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == g) {
				System.out.println(time[g]);
				return;
			}
			if (cur - d >= 1 && time[cur - d] == -1) {
				time[cur - d] = time[cur] + 1;
				q.add(cur - d);
			}
			if (cur + u <= f && time[cur + u] == -1) {
				time[cur + u] = time[cur] + 1;
				q.add(cur + u);
			}
		}
		System.out.println("use the stairs");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		f = Integer.parseInt(stringTokenizer.nextToken());
		s = Integer.parseInt(stringTokenizer.nextToken());
		g = Integer.parseInt(stringTokenizer.nextToken());
		u = Integer.parseInt(stringTokenizer.nextToken());
		d = Integer.parseInt(stringTokenizer.nextToken());

		int[] arr = new int[f + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		arr[s] = 0;
		q.add(s);
		solve(arr);
	}
}