import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];

            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }

}