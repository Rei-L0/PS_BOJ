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
        long res = M;
        
        List<Pair> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            
            if (s > e) list.add(new Pair(e, s));
        }
        
        if (list.size() > 0) {
            Collections.sort(list);
        
            long left = list.get(0).s;
            long right = list.get(0).e;
        
            for (int i = 0; i < list.size(); i++) {
                long s = list.get(i).s;
                long e = list.get(i).e;
            
                if (s <= right) {
                    right = Math.max(right, e);
                } else {
                    res += (right - left) * 2;
                    left = s;
                    right = e;
                }
            }
		    res += (right - left) * 2;
        }
		
		System.out.print(res);
	}
	
	static class Pair implements Comparable<Pair> {
	    long s;
	    long e;
	    
	    Pair (long s, long e) {
	        this.s = s;
	        this.e = e;
	    }
	    
	    @Override
        public int compareTo (Pair p) {
            if (this.s != p.s) {
                return Long.compare(this.s, p.s);
            }
            return Long.compare(this.e, p.e);
        }
	}
}