import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = Integer.MAX_VALUE;
    
    static int N, M;
    
    static int[][] graph;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		
		for (int i = 0; i < N + 1; i++) {
		    Arrays.fill(graph[i], INF);
		}
		
		for (int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    
		    graph[s][e] = w;
		    graph[e][s] = w;
		}
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		    pq.offer(new int[]{s, 0});
		    boolean[] visited = new boolean[N + 1];
		    visited[s] = true;
		    
		    while (!pq.isEmpty()) {
		        int[] now = pq.poll();
		        if(now[0] == e){
		            sb.append(now[1]).append("\n");
		            break;
		        }
		        for (int j = 0; j < N + 1; j++) {
		            if(graph[now[0]][j] != INF && !visited[j]) {
		                visited[j] = true;
		                pq.offer(new int[]{j, now[1] + graph[now[0]][j]});
		            }
		        }
		    }
		}
		System.out.print(sb);
	}
}