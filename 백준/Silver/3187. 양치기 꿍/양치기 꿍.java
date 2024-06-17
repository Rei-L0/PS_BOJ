import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int r, c, s, w;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static boolean[][] visited;

    static class Pos {

        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    solve(new Pos(i, j));
                }
            }
        }

        System.out.println(s + " " + w);
    }

    static void solve(Pos start) {
        Queue<Pos> q = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        q.offer(start);

        int sheep = 0;
        int wolf = 0;

        if (map[start.x][start.y] == 'v') {
            wolf++;
        }
        if (map[start.x][start.y] == 'k') {
            sheep++;
        }

        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (map[nx][ny] == '#' || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 'v') {
                    wolf++;
                }
                if (map[nx][ny] == 'k') {
                    sheep++;
                }
                visited[nx][ny] = true;
                q.offer(new Pos(nx, ny));
            }
        }

        if (sheep > wolf) {
            s += sheep;
        } else {
            w += wolf;
        }
    }

}