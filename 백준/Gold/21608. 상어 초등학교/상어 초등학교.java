import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;
    static int[][] friend;

    static class Pos implements Comparable<Pos> {

        int x;
        int y;
        int like;
        int empty;

        public Pos(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.like == o.like) {
                if (this.empty == o.empty) {
                    if (this.x == o.x) {
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.empty - this.empty;
            }
            return o.like - this.like;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        board = new int[n][n];
        friend = new int[(n * n) + 1][4];

        for (int i = 0; i < n * n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < 4; j++) {
                friend[num][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            setPos(num);
        }

        int ans = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx == n || nx == -1 || ny == n || ny == -1) {
                        continue;
                    }
                    for (int j = 0; j < 4; j++) {
                        if (board[nx][ny] == friend[board[x][y]][j]) {
                            count++;
                        }
                    }
                }
                ans += (int) Math.pow(10, count - 1);
            }
        }
        System.out.println(ans);
    }

    static void setPos(int num) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 0) {
                    int likeCount = 0;
                    int emptyCount = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx == n || nx == -1 || ny == n || ny == -1) {
                            continue;
                        }
                        if (board[nx][ny] == 0) {
                            emptyCount++;
                            continue;
                        }
                        for (int j = 0; j < 4; j++) {
                            if (board[nx][ny] == friend[num][j]) {
                                likeCount++;
                            }
                        }
                    }
                    pq.offer(new Pos(x, y, likeCount, emptyCount));
                }
            }
        }
        Pos finalPos = pq.poll();
        pq.clear();
        board[finalPos.x][finalPos.y] = num;
    }

}