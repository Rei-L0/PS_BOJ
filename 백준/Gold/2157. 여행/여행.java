import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, K, ans;
    
    static List<List<Edge>> graph;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
		    graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < K; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    if (a < b) {
                graph.get(a).add(new Edge(b, c));
            }
		}
		
		int[][] dp = new int[M + 1][N + 1];
		
		for (Edge edge: graph.get(1)) {
		    dp[2][edge.e] = Math.max(dp[2][edge.e], edge.w);
		}
		
		for (int i = 2; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (dp[i][j] == 0) continue;

                for (Edge nextEdge : graph.get(j)) {
                    int nextCity = nextEdge.e;
                    int score = nextEdge.w;
                    
                    dp[i + 1][nextCity] = Math.max(dp[i + 1][nextCity], dp[i][j] + score);
                }
            }
        }

        int ans = 0;
        for (int i = 2; i <= M; i++) {
            ans = Math.max(ans, dp[i][N]);
        }

        System.out.println(ans);
	}
	
	static class Edge {
	    int e;
	    int w;
	    
	    Edge (int e, int w) {
	        this.e = e;
	        this.w = w;
	    }
	}
}