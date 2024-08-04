import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static int n, m;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(i, j, 1, i, j);
            }
        }

        System.out.println("No");
    }

    static void dfs(int x, int y, int cnt, int sx, int sy) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            isFinish(cnt, sx, sy, nx, ny);
            if (visited[nx][ny]) {
                continue;
            }
            if (arr[nx][ny] == arr[sx][sy]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sx, sy);
            }
        }
    }

    private static void isFinish(int cnt, int sx, int sy, int nx, int ny) {
        if (arr[nx][ny] == arr[sx][sy] && nx == sx && ny == sy && cnt >= 4) {
            System.out.println("Yes");
            System.exit(0);
        }
    }
}