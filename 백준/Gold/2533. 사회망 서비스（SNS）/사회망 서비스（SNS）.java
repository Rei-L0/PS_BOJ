import java.util.*;
import java.io.*;

public class Main {
    
    static final int MAX = 1_000_001;
    
    static int N;
    
    static int[][] dp;
    
    static List<List<Integer>> graph;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        } 
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        dp = new int[2][N + 1];
        Arrays.fill(dp[0], MAX);
        Arrays.fill(dp[1], MAX);
        
        dfs(1, 0);
		
		System.out.print(Math.min(dp[0][1], dp[1][1]));
	}
	
	static void dfs (int num, int parent) {
	    dp[0][num] = 0;
	    dp[1][num] = 1;
	    
	    for (int next: graph.get(num)) {
	        if (next == parent) {
	            continue;
	        }
	        
	        dfs(next, num);
	        
	        dp[0][num] += dp[1][next];
	        dp[1][num] += Math.min(dp[0][next], dp[1][next]);
	    }
	}
}