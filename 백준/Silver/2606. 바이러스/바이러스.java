import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, e;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		e = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		boolean[] visit = new boolean[n + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(s).add(end);
			list.get(end).add(s);
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(1);
		visit[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : list.get(now)) {
				if (!visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}

		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (visit[i])
				ans++;
		}
		System.out.println(ans);
	}

}