import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] costs = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            Edge edge = new Edge(i, costs[i]);
            pq.offer(edge);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Edge(e, 0));
            graph.get(e).add(new Edge(s, 0));
        }
        
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        int res = 0;
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if (!visited[now.e]) {
                visited[now.e] = true;
                cnt++;
                res += now.w;
            }
            
            if (res > K) {
                System.out.print("Oh no");
                return;
            }
            
            if (cnt == N + 1) {
                System.out.print(res);
                return;
            }
            
            for (Edge next: graph.get(now.e)) {
                if (!visited[next.e]) {
                    pq.offer(next);
                }
            }
        }
	}
	
	static class Edge implements Comparable<Edge> {
	    int e;
	    int w;
	    
	    Edge (int e, int w) {
	        this.e = e;
	        this.w = w;
	    }
	    
	    public int compareTo(Edge o) {
	        return this.w - o.w;
	    }
	}
}