import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int K = Integer.parseInt(br.readLine());
        int[] dp = new int[T + 1];
        dp[0] = 1;
        
		for (int x = 0; x < K; x++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int p = Integer.parseInt(st.nextToken());
		    int n = Integer.parseInt(st.nextToken());
		    
		    for (int i = T; i >= p; i--) {
		        for (int j = 1; j <= n; j++) {
		            int cost = p * j;
		            if(i - cost >= 0) {
		                dp[i] += dp[i - cost];
		            }else{
		                break;
		            }
		        }
		    }
		}
	
		
		System.out.print(dp[T]);
	}
}