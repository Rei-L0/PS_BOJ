import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, m;
	static String ans;
	static int[] parents;

	static BufferedReader bReader;
	static StringTokenizer st;
	static StringBuilder sb;

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ans = "";
		parents = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}

	}

	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return;
		parents[x] = y;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());
		sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			init();
			sb.append("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bReader.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 1) {
					if (find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}