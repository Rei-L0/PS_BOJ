import java.util.*;
import java.io.*;

public class Main {
    
    static final int MOD = 10007;
    
    static int N, M, H;
    
    static BufferedReader br;
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> studentBlocks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> blocks = new ArrayList<>();
            while (st.hasMoreTokens()) {
                blocks.add(Integer.parseInt(st.nextToken()));
            }
            studentBlocks.add(blocks);
        }
        
        int[] dp = new int[H + 1];
        dp[0] = 1;
        
        for (List<Integer> blocks : studentBlocks) {
            for (int j = H; j >= 1; j--) {
                for (int h : blocks) {
                    if (j >= h) {
                        dp[j] = (dp[j] + dp[j - h]) % MOD;
                    }
                }
            }
        }
        
        System.out.println(dp[H]);
    }
}