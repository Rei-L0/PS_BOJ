import java.util.*;
import java.io.*;

public class Main {
    
    static int[] p;
    static int[][] dp;
    static List<List<Integer>> graph = new ArrayList<>();
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        p = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList());
            if (i > 0) {
                p[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp = new int[2][N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        dfs(1, 0);
        
        System.out.print(Math.max(dp[0][1], dp[1][1]));
	}
	
	static void dfs (int num, int parent) {
	    dp[1][num] = p[num];
	    dp[0][num] = 0;
	    
	    for (int next: graph.get(num)) {
	        if (next == parent) continue;
	        
	        dfs(next, num);
	        
	        dp[1][num] += dp[0][next];
	        dp[0][num] += Math.max(dp[0][next], dp[1][next]);
	        
	    }
	    
	}
}