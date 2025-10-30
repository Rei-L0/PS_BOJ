import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[4][N];
        int[] idx = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (idx[j] == 0 || arr[j][idx[j] - 1] < num) {
                    arr[j][idx[j]] = num;
                    idx[j]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print("NO");
                return;
            }
        }
		System.out.print("YES");
	}
}