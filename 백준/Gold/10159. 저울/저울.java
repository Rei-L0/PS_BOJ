import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[][] graph = new boolean[N + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            
            graph[s][e] = true;
        } 
        
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if(i == j) continue;
                    if(graph[j][i] && graph[i][k]) {
                        graph[j][k] = true;
                    }
                } 
            } 
        } 
        
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < N + 1; j++) {
                if(i == j) continue;
                if(graph[i][j] || graph[j][i]) cnt++;
            }
            System.out.println(N - 1 - cnt);
        } 
		
	}
}