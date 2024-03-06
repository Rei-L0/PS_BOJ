import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, rx, ry, bx, by, ans = 11;

    static final char WALL = '#', GOAL = 'O';

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;

    static void solve(int fx, int fy, int sx, int sy, int count, int d) {
        if (count == 11) {
            return;
        }

        // 빨간 공의 방향에 파란 공이 있는지 확인
        boolean isNear = false;
        // 빨간 공 움직이기
        int x = fx;
        int y = fy;
        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 빨간 공이 구멍에 빠질 때
            if (map[nx][ny] == GOAL) {
                fx = nx;
                fy = ny;
                break;
            }
            // 만약 가려는 방향에 파란 공이 있을 경우
            // 파란 공을 움직인 후 빨간 공의 위치를 정해준다.
            if (nx == sx && ny == sy) {
                isNear = true;
                break;
            }
            if (map[nx][ny] == WALL) {
                fx = x;
                fy = y;
                break;
            }
            x = nx;
            y = ny;
        }

        // 파란 공 움직이기
        x = sx;
        y = sy;
        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 파란 공이 구멍에 빠질 경우
            if (map[nx][ny] == GOAL) {
                sx = nx;
                sy = ny;
                break;
            }
            // 가는 길에 빨간 공이 있을 경우 해당 자리에서 멈춘다.
            if (map[nx][ny] == WALL || (nx == fx && ny == fy)) {
                sx = x;
                sy = y;
                break;
            }
            x = nx;
            y = ny;
        }

        if (isNear) {
            fx = sx + dx[reverse(d)];
            fy = sy + dy[reverse(d)];
        }

        // 파란 공이 들어왔을 경우 그만 진행
        if (map[sx][sy] == GOAL) {
            return;
        }

        // 빨간 공이 구멍에 빠졌을 때 결과 비교
        if (map[fx][fy] == GOAL) {
            ans = Math.min(ans, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            solve(fx, fy, sx, sy, count + 1, i);
        }
    }

    static int reverse(int x) {
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
            return 0;
        }
        if (x == 2) {
            return 3;
        }
        return 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            solve(rx, ry, bx, by, 1, i);
        }

        System.out.println((ans == 11) ? -1 : ans);

    }
}