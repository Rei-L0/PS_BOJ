import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m, b1, b2;
	static int ans = Integer.MAX_VALUE;
	static HashMap<Integer, ArrayList<Integer>> map;

	static void combi(int[] res, int count, int start) {
		if (count == 2) {
			ArrayDeque<Integer> combiQ = new ArrayDeque<>();
			for (int i : res)
				combiQ.offer(i);
			int bfsRes = bfs(combiQ, new int[n + 1]);
			if (ans > bfsRes) {
				b1 = res[0];
				b2 = res[1];
				ans = bfsRes;
			}
			return;
		}
		for (int i = start; i < n + 1; i++) {
			res[count] = i;
			combi(res, count + 1, i + 1);
		}
	}

	static int bfs(ArrayDeque<Integer> q, int[] visit) {
		for (int i = 1; i < visit.length; i++) {
			visit[i] = -1;
		}
		for (int i = 0; i < q.size(); i++) {
			int x = q.poll();
			visit[x] = 0;
			q.offer(x);
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			ArrayList<Integer> arrayList = map.get(cur);
			for (int i = 0; i < arrayList.size(); i++) {
				int next = arrayList.get(i);
				if (visit[next] != -1)
					continue;
				visit[next] = visit[cur] + 2;
				q.offer(next);
			}
		}
		int res = 0;
		for (int i : visit)
			res += i;
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new HashMap<>();
		ArrayList<Integer> arr;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (map.containsKey(s))
				arr = map.get(s);
			else
				arr = new ArrayList<>();
			arr.add(e);
			map.put(s, arr);

			if (map.containsKey(e))
				arr = map.get(e);
			else
				arr = new ArrayList<>();
			arr.add(s);
			map.put(e, arr);
		}

		combi(new int[2], 0, 1);
		System.out.println(b1 + " " + b2 + " " + ans);
	}

}