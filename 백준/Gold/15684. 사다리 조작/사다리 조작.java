import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, h, ans = -1;

    static int[][] graph;

    static List<Pos> avail;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


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

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h + 1][n + 1];

        avail = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = b + 1;
            graph[a][b + 1] = b;
        }

        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (graph[i][j] == 0 && graph[i][j + 1] == 0) {
                    avail.add(new Pos(i, j));
                }
            }
        }

        int cnt = 0;
        while (cnt <= 3) {
            find(0, 0, cnt, new int[cnt]);
            if (ans != -1) {
                break;
            }
            cnt++;
        }
        System.out.println(ans);
    }

    static void find(int cnt, int start, int end, int[] arr) {
        if (cnt == end) {
            check(arr);
            return;
        }
        for (int i = start; i < avail.size(); i++) {
            arr[cnt] = i;
            find(cnt + 1, i + 1, end, arr);
        }
    }

    static void check(int[] idx) {
        int[][] arr = new int[h + 1][n + 1];
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < idx.length; i++) {
            Pos now = avail.get(idx[i]);
            if (arr[now.x][now.y] != 0 || arr[now.x][now.y + 1] != 0) {
                return;
            }
            arr[now.x][now.y] = now.y + 1;
            arr[now.x][now.y + 1] = now.y;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!bfs(1, i, i, arr)) {
                return;
            }
        }
        ans = idx.length;
    }

    static boolean bfs(int x, int y, int idx, int[][] arr) {
        while (x != h + 1) {
            if (arr[x][y] != 0) {
                y = arr[x][y];
            }
            x++;
        }
        return y == idx;
    }
}