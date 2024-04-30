import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		Queue<String> q = new ArrayDeque<>();
		q.add(t);

		int ans = 0;

		while (!q.isEmpty()) {
			String str = q.poll();
			if (s.equals(str)) {
				ans = 1;
				break;
			}
			if (str.length() > s.length()) {
				if (str.charAt(0) == 'B') {
					q.offer(change(str));
				}
				if (str.charAt(str.length() - 1) == 'A')
					q.offer(str.substring(0, str.length() - 1));
			}
		}
		System.out.println(ans);
	}

	static String change(String s) {
		int l = s.length();
		sb = new StringBuilder();
		for (int i = 0; i < l - 1; i++) {
			sb.append(s.charAt(l - i - 1));
		}
		return sb.toString();
	}

}