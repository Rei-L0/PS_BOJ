import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = 1;
        while (true) {
            String s = br.readLine();
            if (s.contains("-")) {
                break;
            }
            sb.append(tc++).append(". ").append(solve(s)).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(String s) {
        int ans = 0;
        ArrayDeque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                q.offer('{');
            } else {
                if (q.isEmpty() || q.peekLast() == '}') {
                    q.offer('}');
                } else if (q.peekLast() == '{') {
                    q.pollLast();
                }
            }
        }

        while (!q.isEmpty()) {
            char close = q.pollLast();
            if (close == '{') {
                ans++;
            }
            char open = q.pollLast();
            if (open == '}') {
                ans++;
            }
        }
        return ans;
    }

}
