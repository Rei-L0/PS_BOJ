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
        long[] dp = new long[31];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < 31; i++) {
            long cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += dp[j] * dp[i - j - 1];
            }
            dp[i] = cnt;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }

}