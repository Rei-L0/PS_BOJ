import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static int[][] map;

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int dis = map[cur.x][cur.y];
            if (dis == -1) {
                return "HaruHaru";
            }
            for (int i = 0; i < dx.length; i++) {
                int x = cur.x + dx[i] * dis;
                int y = cur.y + dy[i] * dis;
                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
                    continue;
                }
                q.add(new Pos(x, y));
                visited[x][y] = true;
            }
        }
        return "Hing";
    }

}