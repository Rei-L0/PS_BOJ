import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    
    static final int INF = 100 * 1000 + 1; 

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0; 
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customers = Integer.parseInt(st.nextToken());
            
            for (int j = customers; j < dp.length; j++) {
                if (dp[j - customers] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - customers] + cost);
                }
            }
        }
        
        int result = INF;
        for (int i = C; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        
        System.out.println(result);
    }
}