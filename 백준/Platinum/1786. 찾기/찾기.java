import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String t = br.readLine();
		String p = br.readLine();

		int tLen = t.length();
		int pLen = p.length();

		int[] pi = new int[pLen];

		// i : 접미사 포인터
		// j : 접두사 포인터

		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && p.charAt(j) != p.charAt(i)) {
				j = pi[j - 1];
			}
			if (p.charAt(j) == p.charAt(i)) {
				pi[i] = ++j;
			} else {
				pi[i] = 0;
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && p.charAt(j) != t.charAt(i)) {
				j = pi[j - 1];
			}
			if (p.charAt(j) == t.charAt(i)) {
				if (j == pLen - 1) {
					cnt++;
					list.add(i - (pLen - 1));
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		sb.append(cnt).append("\n");
		for (int i : list) {
			sb.append(i + 1).append(" ");
		}
		System.out.println(sb);
	}

}