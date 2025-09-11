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
        int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		char[] c = br.readLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
		    int num = c[i] - '0';
		    if (q.isEmpty() || K == 0) {
		       q.offer(num); 
		    } 
		    else {
		        while (!q.isEmpty() && q.peekLast() < num) {
		            q.pollLast();
		            K--;
		            if(K == 0) {
		                break;
		            }
		        }
		        q.offer(num);
		    }
		}
		
		while(K > 0) {
		    q.pollLast();
		    K--;
		}
		
		print(q);
	}
	
	static void print(ArrayDeque<Integer> q) {
	    while(!q.isEmpty()) {
	        System.out.print(q.poll());
	    }
	}
}