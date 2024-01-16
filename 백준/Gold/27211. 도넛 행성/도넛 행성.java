import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Coordinate {

    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 22252 정보 상인 호석
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack<Coordinate> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    ans++;
                    board[i][j] = 1;
                    stack.add(new Coordinate(i, j));
                    while (!stack.isEmpty()) {
                        Coordinate cur = stack.pop();
                        int x = cur.x;
                        int y = cur.y;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            // 범위를 벗어났을 때 처리
                            if (nx < 0) {
                                nx = n - 1;
                            }
                            if (nx == n) {
                                nx = 0;
                            }
                            if (ny < 0) {
                                ny = m - 1;
                            }
                            if (ny == m) {
                                ny = 0;
                            }
                            if (board[nx][ny] == 0) {
                                board[nx][ny] = 1;
                                stack.add(new Coordinate(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        System.out.print(ans);
    }
}