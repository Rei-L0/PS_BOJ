import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("*")) {
                break;
            }
            if (solve(s)) {
                sb.append(s).append(" is surprising.").append("\n");
            } else {
                sb.append(s).append(" is NOT surprising.").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean solve(String s) {
        int l = s.length();
        for (int d = 1; d < l; d++) {
            HashSet<String> set = new HashSet<>();
            for (int start = 0; start < l - d; start++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(start)).append(s.charAt(start + d));
                if (set.contains(sb.toString())) {
                    return false;
                } else {
                    set.add(sb.toString());
                }
            }
        }
        return true;
    }
}
