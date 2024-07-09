import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m, ans;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static char[] d = {'U', 'R', 'L', 'D'};

    static char[][] arr;
    static boolean[][] isGoOutside, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        isGoOutside = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isGoOutside[i][j]) {
                    isGoOutside[i][j] = dfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isGoOutside[i][j]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (d[i] == arr[x][y]) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || isGoOutside[nx][ny]) {
                    isGoOutside[x][y] = true;
                    return true;
                }
                if (visited[nx][ny]) {
                    return isGoOutside[nx][ny];
                }
                isGoOutside[x][y] = dfs(nx, ny);
            }
        }
        return isGoOutside[x][y];
    }

}