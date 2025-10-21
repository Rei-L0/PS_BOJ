import java.util.*;
import java.io.*;

public class Main {
    
    static int R, C;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String input = br.readLine();
            String[] parts = input.split(" ", 3); 
            
            R = Integer.parseInt(parts[0]);
            C = Integer.parseInt(parts[1]); 
            String s = parts[2];
            
            char[][] arr = new char[R][C];
            boolean[][] visited = new boolean[R][C];
            
            for (int i = 0; i < R; i++) {
                Arrays.fill(arr[i], '0');
            }
            
            int x = 0;
            int y = 0;
            int d = 0;
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                String num = charToBin(c);
                
                for (int j = 0; j < num.length(); j++) {
                    char ch = num.charAt(j);
                    
                    arr[x][y] = ch;
                    visited[x][y] = true;
                    
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (isOut(nx, ny) || visited[nx][ny]) {
                        d = (d + 1) % 4;
                        nx = x + dx[d];
                        ny = y + dy[d];
                    }
                    
                    x = nx;
                    y = ny;
                }
            }
            
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(arr[i][j]);
                }
            }
            sb.append("\n");
        }
		System.out.print(sb);
	}
	
	static boolean isOut (int x, int y) {
	    return x < 0 || x >= R || y < 0 || y >= C;
	}
	
	static String charToBin (char c) {
	    StringBuilder str = new StringBuilder();
	    
	    if (c == ' ') {
	        return "00000";
	    }
	    
	    int div = (int)Math.pow(2, 4);
	    int num = c - 'A' + 1;
	    
	    while (div != 0) {
            str.append(num / div);
            num = num % div;
            div /= 2;
	    }
	    
	    return str.toString();
	}
}