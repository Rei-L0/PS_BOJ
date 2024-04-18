import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, ans;

    static int[] dp;
    static Sangdam[] arr;

    static class Sangdam {

        int t;
        int p;

        public Sangdam(int t, int p) {
            super();
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new Sangdam[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i] = new Sangdam(t, p);
        }

        for (int i = 1; i <= n; i++) {
            Sangdam now = arr[i];
            if (i + now.t - 1 <= n) {
                dp[i + now.t - 1] = Math.max(dp[i + now.t - 1], dp[i - 1] + now.p);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[n]);
    }
}