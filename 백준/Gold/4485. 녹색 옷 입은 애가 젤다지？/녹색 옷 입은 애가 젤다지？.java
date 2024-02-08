import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] distance;

    static class Node implements Comparable<Node> {

        int score;
        int x;
        int y;

        public Node(int score, int x, int y) {
            this.score = score;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.score - o.score;
        }
    }

    static void dfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(board[x][y], x, y));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx == -1 || ny == -1 || nx == n || ny == n) {
                    continue;
                }
                if (distance[nx][ny] <= cur.score + board[nx][ny]) {
                    continue;
                }
                distance[nx][ny] = cur.score + board[nx][ny];
                pq.add(new Node(distance[nx][ny], nx, ny));
            }
        }
        ans = distance[n - 1][n - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            ans = Integer.MAX_VALUE;
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            distance = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[0][0] = board[0][0];
            dfs(0, 0);
            System.out.println("Problem " + tc + ": " + ans);
            tc++;
        }


    }
}