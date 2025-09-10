import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
		    int N = Integer.parseInt(br.readLine());
		    
		    int[] coins = new int[N];
		    st = new StringTokenizer(br.readLine());
		    for (int i = 0; i < N; i++){
		        coins[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    int M = Integer.parseInt(br.readLine());
		    int[] dp = new int[M + 1];
		    dp[0] = 1;
		    for (int coin: coins) {
		        for (int i = coin; i < M + 1; i++){
		            dp[i] += dp[i - coin];
		        }
		    }
		    sb.append(dp[M]).append("\n");
		}
		System.out.print(sb);
	}
}