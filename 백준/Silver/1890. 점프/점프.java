import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long ans;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i] * board[x][y];
                int ny = y + dy[i] * board[x][y];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }

}