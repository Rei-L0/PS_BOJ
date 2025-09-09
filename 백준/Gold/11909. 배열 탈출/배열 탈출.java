import java.util.*;
import java.io.*;

class Main {

    static final int INF = 1_000_001;
    
    static int N;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    
    static int[][] arr, dp;

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;
        for (int x = 0; x < N; x++ ) {
            for (int y = 0; y < N; y++ ) {
                for (int d = 0; d < 2; d++ ) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(isIn(nx, ny)){
                        int w = (arr[x][y] - arr[nx][ny]) > 0 ? 0 : arr[nx][ny] - arr[x][y] + 1;
                        dp[nx][ny] = Math.min(dp[nx][ny], dp[x][y] + w);
                    }
                }
            }
        }
        
        System.out.println(dp[N - 1][N - 1]);
    }

    static public boolean isIn (int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }
}