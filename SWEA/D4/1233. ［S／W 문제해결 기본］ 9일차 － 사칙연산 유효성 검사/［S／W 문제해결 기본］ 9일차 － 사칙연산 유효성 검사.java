import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int ans = 1;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				char alpha = st.nextToken().charAt(0);
				if (i > (n / 2)) {
					if (!Character.isDigit(alpha))
						ans = 0;
					continue;
				} else {
					if (Character.isDigit(alpha))
						ans = 0;
				}
				int c1 = Integer.parseInt(st.nextToken());
				if (i == (n / 2) && n % 2 == 0)
					continue;
				int c2 = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t + " " + ans);
		}

	}

}