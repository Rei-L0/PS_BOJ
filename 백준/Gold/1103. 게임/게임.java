import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, ans;

    static boolean isCycle;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] dp;
    static char[][] num;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n][m];
        num = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                num[i][j] = s.charAt(j);
            }
        }

        visit[0][0] = true;

        dfs(0, 0, 1);

        System.out.println(isCycle ? -1 : ans);
    }

    static void dfs(int x, int y, int cnt) {
        if (isCycle) {
            return;
        }
        dp[x][y] = cnt;
        if (cnt > ans) {
            ans = cnt;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * (num[x][y] - '0');
            int ny = y + dy[i] * (num[x][y] - '0');
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || num[nx][ny] == 'H') {
                continue;
            }
            if (cnt < dp[nx][ny]) {
                continue;
            }
            if (visit[nx][ny]) {
                isCycle = true;
                return;
            }
            visit[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            visit[nx][ny] = false;
        }

    }

}