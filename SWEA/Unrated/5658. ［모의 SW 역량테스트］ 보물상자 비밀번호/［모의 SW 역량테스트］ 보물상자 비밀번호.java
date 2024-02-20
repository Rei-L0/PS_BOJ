import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int t, ans, n, k;
	static String str;
	static BufferedReader bReader;
	static StringTokenizer st;
	static PriorityQueue<Integer> pq;
	static HashMap<Integer, Boolean> map;

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		str = bReader.readLine();
		pq = new PriorityQueue<>(Collections.reverseOrder());
		map = new HashMap<>();
	}

	static void rotate(int start) {
		int count = 0;
		String string = "";
		while (count != 4) {
			string += str.charAt(start);
			start++;
			if (start == str.length())
				start = 0;
			if (string.length() == str.length() / 4) {
				int num = Integer.parseInt(string, 16);
				string = "";
				count++;
				if (map.containsKey(num))
					continue;
				pq.add(num);
				map.put(num, true);
			}
		}
	}

	static int solve() {
		for (int i = 0; i < n / 4; i++) {
			rotate(i);
		}
		for (int i = 0; i < k - 1; i++) {
			pq.poll();
		}
		return pq.poll();
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			init();

			System.out.println("#" + tc + " " + solve());
		}

	}
}