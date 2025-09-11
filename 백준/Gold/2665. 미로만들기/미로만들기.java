import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }
        
        boolean[][][] visit = new boolean[N * N + 1][N][N];
        visit[0][0][0] = true;
        
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0, 0));
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(isIn(nx, ny, N)) {
                    int h = now.h;
                    if (arr[nx][ny] == '0') {
                        h++;
                    }
                    if (visit[h][nx][ny] || h >= N * N) {
                        continue;
                    }
                    visit[h][nx][ny] = true;
                    q.offer(new Pos(h, nx, ny));
                }
            }
        }
        
        for (int i = 0; i < N * N + 1; i++) {
            if(visit[i][N - 1][N - 1]){
                System.out.print(i);
                return;
            }
        }
	}
	
	static boolean isIn(int x, int y, int N) {
	    return -1 < x && x < N && -1 < y && y < N;
	}
	
	static class Pos { 
	    int h;
	    int x;
	    int y;
	    
	    Pos (int h, int x, int y) {
	        this.h = h;
	        this.x = x;
	        this.y = y; 
	    }
	}
}