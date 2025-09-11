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
        
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int changeCount = 0;
        int size = 0;
        Set<Integer> con = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int now = arr[i];
            
            if (con.contains(now)) {
                continue;
            }
            
            if (con.size() < N) {
                con.add(now);
                continue;
            }
            
            changeCount++;
            
            int val = -1;
            int max = -1;
            for (int p: con) {
                int dis = K;
                for (int x = i; x < K; x++) {
                    if (p == arr[x]) {
                        dis = x - i;
                        break;
                    }
                }
                if (max < dis) {
                    val = p;
                    max = dis;
                }
            }
            
            con.remove(val);
            con.add(now);
        }
        
		System.out.print(changeCount);
	}
}