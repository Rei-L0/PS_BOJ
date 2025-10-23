import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N]; 
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int target = N;
        int num = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == target) {
                target--;
                num++;
            }
        }
		
		System.out.print(N - num);
	}
}