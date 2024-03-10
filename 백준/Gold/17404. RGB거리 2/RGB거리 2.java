import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, ans = Integer.MAX_VALUE;
    static int[][] map, dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[j], 10000000);
            }
            dp[0][i] = map[0][i];
            for (int j = 1; j < n; j++) {
                dp[j][0] = map[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = map[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = map[j][2] + Math.min(dp[j - 1][1], dp[j - 1][0]);
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    ans = Math.min(ans, dp[n - 1][j]);
                }
            }
        }

        System.out.println(ans);
    }
}