import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n, m, ans, num;

    static final int INF = 10000;

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int[] p;
    static int[][] map, graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {

        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                "s=" + s +
                ", e=" + e +
                ", w=" + w +
                '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static void makeNum(int x, int y) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(x, y));
        visited[x][y] = true;
        map[x][y] = num;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                q.add(new Pos(nx, ny));
                visited[nx][ny] = true;
                map[nx][ny] = num;
            }
        }
    }

    static void calcDistance(int x, int y, int nowNum) {
        for (int i = 0; i < 4; i++) {
            // 거리 변수
            int count = 0;
            int sx = x;
            int sy = y;
            while (true) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                count++;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    break;
                }
                if (map[nx][ny] == nowNum) {
                    break;
                }
                sx = nx;
                sy = ny;
                if (map[nx][ny] != 0 && map[nx][ny] != nowNum) {
                    if (count == 2) {
                        break;
                    }
                    graph[nowNum][map[nx][ny]] = Math.min(graph[nowNum][map[nx][ny]], count - 1);
                    break;
                }
            }
        }
    }

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return find(p[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }

        p[x] = p[y];
        return true;
    }

    static void kruskal() {
        int count = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (union(now.s, now.e)) {
                count++;
                ans += now.w;
            }
        }
        if (count != num - 2) {
            ans = -1;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        num = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    makeNum(i, j);
                    num++;
                }
            }
        }

        graph = new int[num][num];
        p = new int[num];
        for (int i = 0; i < num; i++) {
            p[i] = i;
            for (int j = 0; j < num; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    calcDistance(i, j, map[i][j]);
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (graph[i][j] == INF || graph[i][j] == 1) {
                    continue;
                }
                pq.add(new Node(i, j, graph[i][j]));
            }
        }

        kruskal();

        System.out.println(ans);

    }
}