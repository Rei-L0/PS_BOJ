import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, t;


    static class Chapter {

        int k;
        int s;

        public Chapter(int k, int s) {
            this.k = k;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        Chapter[] list = new Chapter[n + 1];
        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[i] = new Chapter(k, s);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < t + 1; j++) {
                if (j >= list[i].k) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list[i].k] + list[i].s);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][t]);
    }

}