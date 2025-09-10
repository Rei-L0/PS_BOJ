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
        int C = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        Path[] pathes = new Path[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            pathes[i] = new Path(s, e, w);
        }
        
        Arrays.sort(pathes, (a, b) -> {
            if(a.e == b.e){
                if(a.s == b.s){
                    return b.w - a.w;
                }
                return a.s - b.s;
            }
            return a.e - b.e;
        });
        
        int res = 0;
        int[] capacity = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            Path path = pathes[i];
            
            int max_val = 0;
            for(int j = path.s; j < path.e; j++){
                max_val = Math.max(max_val, capacity[j]);
            }
            
            int avail = Math.min(C - max_val, path.w);
            if(avail > 0) {
                for(int j = path.s; j < path.e; j++){
                    capacity[j] += avail;
                }
            }
            
            res += avail;
        }
		
		System.out.print(res);
	}
	
	static class Path {
	    int s, e, w;
	    
	    Path(int s, int e, int w) {
	        this.s = s;
	        this.e = e;
	        this.w = w;
	    }
	}
}