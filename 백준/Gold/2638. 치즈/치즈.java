import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] map;

    static ArrayDeque<Pos> melt = new ArrayDeque<>();

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void spread() {
        while (!melt.isEmpty()) {
            Pos now = melt.poll();
            map[now.x][now.y] = 2;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 1 || map[nx][ny] == 2) {
                    continue;
                }
                melt.add(new Pos(nx, ny));
                map[nx][ny] = 2;
            }
        }
    }

    static boolean solve(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (map[nx][ny] == 2) {
                count++;
            }
        }
        return count >= 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        melt.add(new Pos(0, 0));
        map[0][0] = 2;
        ans = 0;
        while (!melt.isEmpty()) {
            spread();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        if (solve(i, j)) {
                            melt.add(new Pos(i, j));
                        }
                    }
                }
            }
            ans++;
        }
        System.out.println(ans - 1);
    }
}