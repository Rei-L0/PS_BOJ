import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bReader;
	static StringTokenizer st;
	static char[] c;
	static char[] include = { 'a', 'e', 'i', 'o', 'u' };
	static int n, m;
	static PriorityQueue<String> pq = new PriorityQueue<>();

	static void solve(char[] res, int count, int start) {
		if (count == n) {
			int ja = 0;
			int mo = 0;
			for (int i = 0; i < n; i++) {
				if (checkMo(res[i]))
					mo++;
				else
					ja++;
			}
			if (ja >= 2 && mo >= 1) {
				pq.add(new String(res));
			}
			return;
		}
		for (int i = start; i < m; i++) {
			res[count] = c[i];
			solve(res, count + 1, i + 1);
		}
	}

	static boolean checkMo(char c) {
		for (int j = 0; j < include.length; j++) {
			if (c == include[j])
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		c = new char[m];
		st = new StringTokenizer(bReader.readLine());

		for (int i = 0; i < m; i++) {
			c[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(c);

		solve(new char[n], 0, 0);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

}