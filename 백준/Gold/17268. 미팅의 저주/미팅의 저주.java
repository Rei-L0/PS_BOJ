import java.io.*;
import java.util.*;

class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static final int M = 987654321;

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        long[] dp = new long[5000 + 1];
        dp[0] = 1;

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - 1 - j]) % M;
            }
            dp[i] %= M;
        }

        System.out.println(dp[n / 2]);
    }
}