import java.util.*;
import java.io.*;

public class Main {
    
    static int N, K, B;
    
    static StringBuilder sb;
    static BufferedReader br;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        boolean[] arr = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = true;
        }
        
        int cnt = 0;
        int ans = N + 1;
        for (int i = 1; i <= K; i++) {
            if(arr[i]) cnt++;
        }
        ans = Math.min(cnt, ans);
        
        for (int i = K + 1; i < N + 1; i++) {
            if(arr[i]) cnt++;
            if(arr[i - K]) cnt--;
            
            ans = Math.min(cnt, ans);
        } 
        
        System.out.print(ans);
	}
}