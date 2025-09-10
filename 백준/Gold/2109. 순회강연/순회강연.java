import java.util.*;
import java.io.*;

public class Main {
    
    static final int MAX = 10001;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] res = new int[MAX];
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            arr[i][0] = p;
            arr[i][1] = d;
        }
        
        Arrays.sort(arr, (a, b) -> (b[0] - a[0]));
        
        for (int i = 0; i < N; i++) {
            for (int j = arr[i][1]; j > 0; j--) {
                if (res[j] == 0){
                    res[j] = arr[i][0];
                    break;
                }
            }
        }
        
        int ans = 0;
        for (int r: res){
            ans += r;
        }
	
	    System.out.print(ans);	
	}
}