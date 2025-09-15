import java.util.*;
import java.io.*;

public class Main {
    
    static int K;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[K + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int wt = Integer.parseInt(st.nextToken());
            int wm = Integer.parseInt(st.nextToken());
            int bt = Integer.parseInt(st.nextToken());
            int bm = Integer.parseInt(st.nextToken());
            
            int[] next_dp = new int[K + 1];
            Arrays.fill(next_dp, -1);
            
            calc(dp, next_dp, wt, wm);
            calc(dp, next_dp, bt, bm);
            
            dp = next_dp;
        }
        
        for (int i = 0; i < K + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
		
		System.out.print(ans);
	}
	
	static void calc (int[] dp, int[] next_dp, int t, int m) {
	    for (int x = 0; x < K + 1; x++) {
            if (dp[x] == -1) continue;
            if (x + t <= K) {
                next_dp[x + t] = Math.max(next_dp[x + t], dp[x] + m);
            }
        }
	}
}