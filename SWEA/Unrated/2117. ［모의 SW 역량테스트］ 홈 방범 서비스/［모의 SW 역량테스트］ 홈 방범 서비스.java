import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int t, n, m, ans;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void solve(int x, int y, int num) {
        int cost = num * num + (num - 1) * (num - 1);
        int house = 0;

        ArrayDeque<Pos> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        q.add(new Pos(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            if (board[now.x][now.y] == 1) {
                house++;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOut(nx, ny) || visit[nx][ny]) {
                    continue;
                }
                if (Math.abs(nx - x) + Math.abs(ny - y) > num - 1) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new Pos(nx, ny));
            }
        }

        if (house * m >= cost) {
            ans = Math.max(house, ans);
        }
    }

    static boolean isOut(int x, int y) {
        return (x == -1 || y == -1 || x == n || y == n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ans = 0;
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int num = 1; num <= n + 1; num++) {
                        solve(i, j, num);
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}