import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] p;
	static BufferedReader bReader;
	static StringTokenizer st;

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		p[x] = y;
		return true;
	}

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n];

		for (int i = 0; i < n; i++)
			p[i] = i;

		boolean isFinish = false;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				isFinish = true;
				System.out.println(i);
				break;
			}
		}

		if (!isFinish) {
			System.out.println(0);
		}
	}
}