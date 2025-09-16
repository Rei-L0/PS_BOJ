import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int size = 1;
        
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];   
            }
            return a[0] - b[0];
        });
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < N; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            
            while (!pq.isEmpty() && pq.peek()[1] <= s) {
                pq.poll();
            }
            
            pq.offer(new int[]{s, e});
            
            if (pq.size() > size) {
                size++;
            }
        }
        
		System.out.print(size);
	}
}