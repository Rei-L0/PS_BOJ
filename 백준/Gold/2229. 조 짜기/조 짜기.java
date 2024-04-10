import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int[] num, dp;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = 10001;
            int max = 0;
            num[i] = Integer.parseInt(st.nextToken());
            for (int j = i; j > 0; j--) {
                min = Math.min(min, num[j]);
                max = Math.max(max, num[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }
        System.out.println(dp[n]);
    }
}