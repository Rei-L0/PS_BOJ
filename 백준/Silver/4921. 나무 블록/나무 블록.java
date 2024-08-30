import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int idx = 1;

        while (true) {
            String n = br.readLine();
            if (n.equals("0")) {
                break;
            }
            sb.append(idx++).append(". ").append(solve(n)).append("\n");
        }

        System.out.println(sb);
    }

    static String solve(String s) {
        if (!(s.charAt(0) == '1' && s.charAt(s.length() - 1) == '2')) {
            return "NOT";
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2') {
                return "NOT";
            }

            if (s.charAt(i) == '3') {
                if (!(s.charAt(i - 1) == '4' || s.charAt(i - 1) == '6')) {
                    return "NOT";
                }
                if (!(s.charAt(i + 1) == '4' || s.charAt(i + 1) == '5')) {
                    return "NOT";
                }
            }

            if (s.charAt(i) == '4') {
                if (!(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '3')) {
                    return "NOT";
                }
                if (!(s.charAt(i + 1) == '2' || s.charAt(i + 1) == '3')) {
                    return "NOT";
                }
            }

            if (s.charAt(i) == '5') {
                if (!(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '3')) {
                    return "NOT";
                }
                if (!(s.charAt(i + 1) == '8')) {
                    return "NOT";
                }
            }

            if (s.charAt(i) == '6') {
                if (!(s.charAt(i + 1) == '2' || s.charAt(i + 1) == '3')) {
                    return "NOT";
                }
                if (!(s.charAt(i - 1) == '8')) {
                    return "NOT";
                }
            }

            if (s.charAt(i) == '7') {
                if (!(s.charAt(i - 1) == '8')) {
                    return "NOT";
                }
                if (!(s.charAt(i + 1) == '8')) {
                    return "NOT";
                }
            }

            if (s.charAt(i) == '8') {
                if (!(s.charAt(i - 1) == '5' || s.charAt(i - 1) == '7')) {
                    return "NOT";
                }
                if (!(s.charAt(i + 1) == '6' || s.charAt(i + 1) == '7')) {
                    return "NOT";
                }
            }
        }
        return "VALID";
    }

}