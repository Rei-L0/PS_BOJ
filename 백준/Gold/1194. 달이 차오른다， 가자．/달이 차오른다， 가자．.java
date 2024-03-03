import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

    static int n, m, ans, sx, sy;

    static char[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    static class Pos {

        int key;
        int x;
        int y;

        public Pos(int key, int x, int y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }
    }

    static int solve() {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        int[][][] visit = new int[64][n][m];
        q.add(new Pos(0, sx, sy));
        visit[0][sx][sy] = 1;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextKey = now.key;
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == '1') {
                    return visit[nextKey][now.x][now.y];
                }
                if (map[nx][ny] == '#' || visit[nextKey][nx][ny] != 0) {
                    continue;
                }
                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    nextKey = nextKey | 1 << (map[nx][ny] - 'a');
                } else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if ((nextKey & 1 << (map[nx][ny] - 'A')) == 0) {
                        continue;
                    }
                }
                q.add(new Pos(nextKey, nx, ny));
                visit[nextKey][nx][ny] = visit[now.key][now.x][now.y] + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = 0;
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }

        System.out.println(solve());
    }
}