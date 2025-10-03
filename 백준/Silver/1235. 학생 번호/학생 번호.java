import java.util.*;
import java.io.*;

public class Main {
    
    static int N; 
    static String[] arr;
    
    static BufferedReader br;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();   
        }
        
        for (int i = 1; i <= arr[0].length(); i++) {
            if (check(i)) {
                System.out.print(i);
                return;
            }
        }
	}
	
	static boolean check(int n) {
	    Set<String> set = new HashSet<>();
	    
	    for (int i = 0; i < N; i++) {
	        String subStr = subString(n, arr[i]);
	        if (set.contains(subStr)) {
	            return false;
	        }
	        set.add(subStr);
	    }
	    return true;
	}
	
	static String subString(int n, String s) {
	    StringBuilder sb = new StringBuilder();
	    int len = s.length();
	    for (int i = len - n; i < len; i++) {
	        sb.append(s.charAt(i));
	    }
	    return sb.toString();
	}
}