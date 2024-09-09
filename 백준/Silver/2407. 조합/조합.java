import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // BigInteger 배열을 0으로 초기화
        BigInteger[][] dp = new BigInteger[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        // dp 배열 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j == 1 || j == i - 1) {
                    dp[i][j] = BigInteger.valueOf(i);
                } else if (j == i) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j].add(dp[i - 1][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
