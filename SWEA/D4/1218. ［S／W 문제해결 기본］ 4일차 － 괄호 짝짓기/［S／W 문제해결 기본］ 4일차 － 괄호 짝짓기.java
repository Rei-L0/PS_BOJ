import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int ans = 1;
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				char input = str.charAt(i);
				if (input == '(' || input == '{' || input == '[' || input == '<')
					stack.add(input);
				else {
					if (input == ')') {
						if (stack.pollLast() != '(') {
							ans = 0;
							break;
						}
					} else if (input == '}') {
						if (stack.pollLast() != '{') {
							ans = 0;
							break;
						}
					} else if (input == ']') {
						if (stack.pollLast() != '[') {
							ans = 0;
							break;
						}
					} else {
						if (stack.pollLast() != '<') {
							ans = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}