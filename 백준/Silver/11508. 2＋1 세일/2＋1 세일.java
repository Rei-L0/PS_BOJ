import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            cnt++;
            if(cnt != 3) {
                ans += num;
            } else {
                cnt = 0;
            }
        }
		System.out.print(ans);
	}
}