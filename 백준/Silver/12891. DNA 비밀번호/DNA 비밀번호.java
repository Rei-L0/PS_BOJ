import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int s, p, ans = 0;
	static Map<Character, Integer> include = new HashMap<>();

	private static boolean check(int[] arr) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i] <= 0)
				count++;
		}
		if (count == 4)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		s = Integer.parseInt(stringTokenizer.nextToken());
		p = Integer.parseInt(stringTokenizer.nextToken());

		String str = br.readLine();

		int[] count = new int[4];

		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		include.put('A', 0);
		include.put('C', 1);
		include.put('G', 2);
		include.put('T', 3);

		int start = 0;
		int end = p - 1;

		for (int i = 0; i <= end; i++) {
			count[include.get(str.charAt(i))]--;
		}

		while (true) {
			if (check(count)) {
				ans++;
			}
			count[include.get(str.charAt(start))]++;
			start += 1;
			end += 1;
			if (end == s)
				break;
			count[include.get(str.charAt(end))]--;
		}
		System.out.println(ans);
	}

}