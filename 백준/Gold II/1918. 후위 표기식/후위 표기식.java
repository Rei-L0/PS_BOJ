import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {

	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Character, Integer> map = new HashMap<>();

		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 3);
		map.put(')', 3);

		ArrayDeque<Character> q = new ArrayDeque<>();
		String string = bReader.readLine();
		String ans = "";
		for (int i = 0; i < string.length(); i++) {
			char now = string.charAt(i);
			if (!map.containsKey(now))
				ans += string.charAt(i);
			else {
				if (now == ')') {
					while (!q.isEmpty()) {
						char x = q.pollLast();
						if (x == '(')
							break;
						ans += x;
					}
					continue;
				}
				while (!q.isEmpty()) {
					char top = q.peekLast();
					if (map.get(top) < map.get(now) || top == '(')
						break;
					ans += q.pollLast();
				}
				q.add(now);
			}
		}
		while (!q.isEmpty())
			ans += q.pollLast();
		System.out.println(ans);
	}
}