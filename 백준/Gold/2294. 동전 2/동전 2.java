import java.util.*;
import java.io.*;

public class Main {
    
    static int INF = 100001;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[K + 1];
        Arrays.fill(coins, INF);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            for (int j = 1; num * j <= K; j++) {
                coins[num * j] = Math.min(coins[num * j], j);
            }
        }
        
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = K; i > 0; i--) {
            if (coins[i] == INF) continue;
            for (int j = 0; i + j <= K; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[j] + coins[i]);
            }
        }
        
        System.out.print(dp[K] != INF ? dp[K] : -1);
	}
}