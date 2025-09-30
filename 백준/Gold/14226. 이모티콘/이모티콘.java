import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
		int[][] arr = new int[N + 1][N + 1];
		
		for (int i = 0; i < N + 1; i++) {
		    Arrays.fill(arr[i], 1_000_001);
		} 
		
		pq.offer(new Info(1, 0, 0));
		
		while (!pq.isEmpty()) {
		    Info now = pq.poll();
		    
		    int screen = now.screen;
		    int clip = now.clip;
		    int cnt = now.cnt;
		    
		    if (now.screen == N) {
		        System.out.print(now.cnt);
		        return;
		    }
		    
		    // 클립보드 저장
		    if (arr[screen][screen] > cnt + 1) {
		        arr[screen][screen] = cnt + 1;
		        pq.offer(new Info(screen, screen, cnt + 1));   
		    }
		    // 클립보드 붙여넣기
		    if (0 < clip && screen + clip < N + 1 && arr[screen + clip][clip] > cnt + 1) {
		        arr[screen + clip][clip] = cnt + 1;
		        pq.offer(new Info(screen + now.clip, clip, cnt + 1));   
		    }
		    // 화면에서 1개 삭제하기
		    if (2 < screen && arr[screen - 1][clip] > cnt + 1) {
		        arr[screen - 1][clip] = cnt + 1;
		        pq.offer(new Info(screen - 1, clip, cnt + 1));   
		    }
		}
	}
	
	static class Info {
	    int screen;
	    int clip;
	    int cnt;
	    
	    Info (int screen, int clip, int cnt) {
	        this.screen = screen;
	        this.clip = clip;
	        this.cnt = cnt;
	    }
	}
}