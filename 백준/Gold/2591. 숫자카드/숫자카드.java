import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2591
public class Main {

    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - '0';
            if (now != 0) {
                dp[i + 1] += dp[i];
                if (i + 1 != s.length() && now * 10 + s.charAt(i + 1) - '0' <= 34) {
                    dp[i + 2] += dp[i];
                }
            }
        }

        System.out.println(dp[s.length()]);
    }

}