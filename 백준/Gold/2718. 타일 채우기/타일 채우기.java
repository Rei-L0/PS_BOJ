import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        int[] dp = new int[1_000_001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 5;
        dp[3] = 11;
        
        for (int i = 4; i < 1_000_001; i++) {
            dp[i] = (dp[i - 2] * dp[2]) + dp[i - 1] + dp[i - 3] - dp[i - 4];
        }
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            sb.append(dp[n]).append("\n");
        }
        
        System.out.print(sb);
	}
}