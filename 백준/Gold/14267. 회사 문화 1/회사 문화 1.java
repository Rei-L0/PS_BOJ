import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    
    static List<Integer>[] graph;
    static int[] praise;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++){
		    graph[i] =  new ArrayList<Integer>();
		}
		
		praise = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++){
		    int e = Integer.parseInt(st.nextToken());
		    if(e == -1){
		        continue;
		    }
		    graph[e].add(i);
		}
		
		for (int i = 0; i < M; i++){
		    st = new StringTokenizer(br.readLine());
		    int num = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    praise[num] += w;
		}
		
		dfs(1);
		
		for (int i = 1; i < N + 1; i++){
		    System.out.print(praise[i] + " ");
		}
	}
	
	static void dfs(int s){
	    for (int i = 0; i < graph[s].size(); i++){
	        int next = graph[s].get(i);
	        praise[next] += praise[s];
	        dfs(next);
	    }
	}
	
}