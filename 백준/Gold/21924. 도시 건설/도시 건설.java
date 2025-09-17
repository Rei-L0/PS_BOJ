import java.util.*;
import java.io.*;

public class Main {
    
    static int[] p;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        long sum_w = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        } 
        
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    
		    sum_w += w;
		    pq.offer(new Edge(s, e, w));
		}
		
		int cnt = 0;
		while (!pq.isEmpty()) {
		    Edge edge = pq.poll();
		    
		    if (!union(edge.s, edge.e)) {
		        cnt++;
		        sum_w -= edge.w;
		    }
		    
		    if (cnt == N - 1) {
		        System.out.print(sum_w);
		        return;
		    }
		}
		
		System.out.print(-1);
	}
	
	static int find (int x) {
	    if(x != p[x]) {
	        return p[x] = find(p[x]);
	    }
	    return x;
	}
	
	static boolean union (int x, int y) {
	    int px = find(x);
	    int py = find(y);
	    
	    if (px == py) {
	        return true;
	    }
	    
	    p[px] = py;
	    return false;
	}
	
	static class Edge implements Comparable<Edge> {
	    int s;
	    int e;
	    int w;
	    
	    Edge (int s, int e, int w) {
	        this.s = s;
	        this.e = e;
	        this.w = w;
	    }
	    
	    public int compareTo (Edge o) {
	        return this.w - o.w;
	    } 
	}
}