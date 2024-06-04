import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        char[] mo = {'a', 'e', 'i', 'o', 'u'};

        while (true) {
            String s = br.readLine();
            if (s.equals("#")) {
                break;
            }
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < mo.length; j++) {
                    if (s.charAt(i) == mo[j] || s.charAt(i) == Character.toUpperCase(mo[j])) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }

}