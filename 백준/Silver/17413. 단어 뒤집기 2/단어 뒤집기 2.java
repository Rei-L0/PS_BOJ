import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        sb = new StringBuilder();

        ArrayDeque<Character> deque = new ArrayDeque<>();

        boolean tag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }
                deque.add(s.charAt(i));
                tag = true;
                continue;
            } else if (s.charAt(i) == '>') {
                deque.add(s.charAt(i));
                while (!deque.isEmpty()) {
                    sb.append(deque.poll());
                }
                tag = false;
                continue;
            }
            if (s.charAt(i) == ' ') {
                if (tag) {
                    deque.add(s.charAt(i));
                    continue;
                }
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }
                sb.append(' ');
                continue;
            }
            deque.add(s.charAt(i));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        System.out.println(sb.toString());
    }

}