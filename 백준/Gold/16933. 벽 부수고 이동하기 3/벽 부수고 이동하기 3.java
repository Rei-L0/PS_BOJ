import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16933
public class Main {

    static int n, m, k;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;

    static class Pos {

        int d;
        int z;
        int x;
        int y;

        public Pos(int d, int z, int x, int y) {
            this.d = d;
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    // 현재 칸의 값이 홀수일 때는 바로 벽 부수기
    // 짝수일 때는 +2 해주기

    static int solve() {
        int ans = Integer.MAX_VALUE;
        int[][][][] dis = new int[2][k + 1][n][m];
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 0, 0));
        for (int i = 0; i < k + 1; i++) {
            dis[0][i][0][0] = 1;
            dis[1][i][0][0] = 1;
        }

        while (!q.isEmpty()) {
            Pos now = q.poll();
            int before = dis[now.d][now.z][now.x][now.y];
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                // 벽일 때
                if (map[nx][ny] == 1) {
                    if (now.z >= k) {
                        continue;
                    }
                    if (now.d == 0) {
                        if (dis[1][now.z + 1][nx][ny] != 0) {
                            continue;
                        }
                        dis[1][now.z + 1][nx][ny] = before + 1;
                        q.add(new Pos(1, now.z + 1, nx, ny));
                    } else {
                        if (dis[1][now.z + 1][nx][ny] != 0) {
                            continue;
                        }
                        dis[0][now.z][now.x][now.y] = before + 1;
                        q.add(new Pos(0, now.z, now.x, now.y));
                    }
                } else {
                    // 낮일 때
                    if (now.d == 0) {
                        if (dis[1][now.z][nx][ny] != 0) {
                            continue;
                        }
                        dis[1][now.z][nx][ny] = before + 1;
                        q.add(new Pos(1, now.z, nx, ny));
                    } else {
                        if (dis[0][now.z][nx][ny] != 0) {
                            continue;
                        }
                        dis[0][now.z][nx][ny] = before + 1;
                        q.add(new Pos(0, now.z, nx, ny));
                    }
                }
            }
        }
        for (int i = 0; i < k + 1; i++) {
            if (dis[0][i][n - 1][m - 1] == 0) {
                continue;
            }
            ans = Math.min(ans, dis[0][i][n - 1][m - 1]);
        }

        for (int i = 0; i < k + 1; i++) {
            if (dis[1][i][n - 1][m - 1] == 0) {
                continue;
            }
            ans = Math.min(ans, dis[1][i][n - 1][m - 1]);
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(solve());
    }
}