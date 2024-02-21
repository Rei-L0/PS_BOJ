import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bReader;
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> arr;
	static int n, m, ans;

	static void solve(int start, int count, boolean[] visit) {
		if (count == 4) {
			ans = 1;
			return;
		}
		for (int i = 0; i < arr.get(start).size(); i++) {
			int next = arr.get(start).get(i);
			if (visit[next])
				continue;
			visit[next] = true;
			solve(next, count + 1, visit);
			visit[next] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		for (int i = 0; i < n; i++) {
			boolean[] arr = new boolean[n];
			arr[i] = true;
			solve(i, 0, arr);
			if (ans == 1)
				break;
		}

		System.out.println(ans);
	}

}