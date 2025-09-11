import java.util.*;
import java.io.*;

public class Main {
    
    static int N; 
    static long M;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        long[] arr = new long[N];
        long min_val = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            min_val = Math.min(min_val, arr[i]);
        }
        
		long left = 0;
		long right = min_val * M;
		
		while (left < right) {
		    long mid = (left + right) >>> 1;

		    if (check(arr, mid)) {
		        right = mid;
		    } else {
		        left = mid + 1;
		    }
		}
		
		System.out.print(left);
	}
	
	static boolean check(long[] arr, long mid) {
	    long cnt = 0;
	    for (int i = 0; i < N; i++) {
	        cnt += mid / arr[i];
	        if(cnt >= M) {
	            return true;
	        }
	    }
	    return false;
	}
}