import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 2_00_001;

	static int n, k;

	static int[] p;

	static List<Integer> route = new ArrayList<>();

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		p = new int[MAX];
		Arrays.fill(p, -2);
		p[n] = -1;

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == k) {
				int x = now;
				while (p[x] != -1) {
					route.add(x);
					x = p[x];
				}
				route.add(n);
				break;
			}
			if (now - 1 > -1 && p[now - 1] == -2) {
				p[now - 1] = now;
				q.add(now - 1);
			}
			if (now + 1 < MAX && p[now + 1] == -2) {
				p[now + 1] = now;
				q.add(now + 1);
			}
			if (now * 2 < MAX && p[now * 2] == -2) {
				p[now * 2] = now;
				q.add(now * 2);
			}
		}

		sb.append(route.size() - 1).append("\n");
		for (int i = route.size() - 1; i >= 0; i--)
			sb.append(route.get(i)).append(" ");
		System.out.println(sb);

	}
}