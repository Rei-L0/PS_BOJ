import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<Integer>[] arrayList;
	static int[] ans;

	static void solve(int start) {
		ans = new int[n + 1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		while (!q.isEmpty()) {
			int parent = q.poll();
			for (int i = 0; i < arrayList[parent].size(); i++) {
				if (ans[arrayList[parent].get(i)] == 0) {
					ans[arrayList[parent].get(i)] = parent;
					q.add(arrayList[parent].get(i));
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());

		arrayList = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++)
			arrayList[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bReader.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arrayList[s].add(e);
			arrayList[e].add(s);
		}

		solve(1);

		for (int i = 2; i < n + 1; i++)
			System.out.println(ans[i]);
	}
}