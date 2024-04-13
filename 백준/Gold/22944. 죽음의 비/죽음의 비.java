import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, h, d, ans;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] board;
    static int[][] visit;

    static Queue<Pos> q = new ArrayDeque<>();

    static class Pos {

        int x, y, u, l;

        public Pos(int x, int y, int u, int l) {
            this.x = x;
            this.y = y;
            this.u = u;
            this.l = l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new char[n][n];
        visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') {
                    q.add(new Pos(i, j, 0, h));
                    visit[i][j] = h;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (--size >= 0) {
                Pos now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 'E') {
                        return dis + 1;
                    }

                    int nu = now.u;
                    int nl = now.l;
                    if (board[nx][ny] == 'U') {
                        nu = d;
                    }

                    if (nu != 0) {
                        nu--;
                    } else {
                        nl--;
                    }

                    if (nl == 0) {
                        continue;
                    }

                    if (visit[nx][ny] < nl + nu) {
                        visit[nx][ny] = nl + nu;
                        q.offer(new Pos(nx, ny, nu, nl));
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}