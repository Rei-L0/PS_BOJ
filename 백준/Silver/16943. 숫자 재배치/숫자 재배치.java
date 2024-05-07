import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String a;
	static int b, ans = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());

		int aLen = a.length();

		permutation(0, new boolean[aLen], new char[aLen]);

		System.out.println(ans);
	}

	static void permutation(int len, boolean[] visit, char[] arr) {
		if (len == a.length()) {
			int res = Integer.parseInt(String.valueOf(arr));
			if (res < b) {
				ans = Math.max(ans, res);
			}
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			if (visit[i])
				continue;
			if (len == 0 && a.charAt(i) == '0')
				continue;
			visit[i] = true;
			arr[len] = a.charAt(i);
			permutation(len + 1, visit, arr);
			visit[i] = false;
		}
	}

}