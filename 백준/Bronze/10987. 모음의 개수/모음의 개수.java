import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = { 'a', 'e', 'i', 'o', 'u' };

		String s = br.readLine();
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j] == s.charAt(i)) {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}

}