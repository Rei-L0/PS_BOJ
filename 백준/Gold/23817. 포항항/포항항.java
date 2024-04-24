import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

// 23817 포항항 mst
public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, ans = Integer.MAX_VALUE;

    static int[] startDis;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] graph;
    static char[][] board;

    static List<Pos> list = new ArrayList<>();

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        Pos start = null;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') {
                    board[i][j] = '.';
                    start = new Pos(i, j);
                }
                if (board[i][j] == 'K') {
                    list.add(new Pos(i, j));
                }
            }
        }

        if (list.size() < 5) {
            System.out.println(-1);
        } else {
            graph = new int[list.size()][list.size()];
            startDis = bfs(start);
            for (int i = 0; i < list.size(); i++) {
                graph[i] = bfs(list.get(i));
            }
            permutation(0, new int[5], new boolean[list.size()]);
            System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
        }
    }

    static void permutation(int cnt, int[] arr, boolean[] visit) {
        if (cnt == 5) {
            int res = 0;
            if (startDis[arr[0]] == 0) {
                return;
            }
            res += startDis[arr[0]];
            for (int i = 0; i < arr.length - 1; i++) {
                if (graph[arr[i]][arr[i + 1]] == 0) {
                    return;
                }
                res += graph[arr[i]][arr[i + 1]];
            }
            ans = Math.min(ans, res);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visit[i]) {
                continue;
            }
            arr[cnt] = i;
            visit[i] = true;
            permutation(cnt + 1, arr, visit);
            visit[i] = false;
        }
    }

    static int[] bfs(Pos start) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);
        int[] res = new int[list.size()];
        int[][] dis = new int[n][m];
        dis[start.x][start.y] = 1;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || dis[nx][ny] != 0) {
                    continue;
                }
                Pos next = new Pos(nx, ny);
                if (board[nx][ny] == '.') {
                    dis[nx][ny] = dis[now.x][now.y] + 1;
                    q.add(next);
                } else if (board[nx][ny] == 'K') {
                    for (int j = 0; j < list.size(); j++) {
                        Pos p = list.get(j);
                        if (p.equals(next)) {
                            res[j] = dis[now.x][now.y];
                        }
                    }
                    dis[nx][ny] = dis[now.x][now.y] + 1;
                    q.add(next);
                }
            }
        }
        return res;
    }

}