import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Snake {

    int x;
    int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n*n board 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];

        // 사과 위치 입력 받기
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 2;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;

        // 방향 전환 정보
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        char[] move = new char[10001];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            move[x] = c;
        }
        int time = 0;
        Deque<Snake> snake = new ArrayDeque<>();
        snake.addFirst(new Snake(0, 0));
        board[0][0] = 1;
        while (true) {
            time++;
            Snake head = snake.getFirst();
            int tmp_x = head.x;
            int tmp_y = head.y;
            // 머리 전진
            tmp_x += dx[d];
            tmp_y += dy[d];

            // 벽에 부딪힐 시 게임 끝
            if (tmp_x < 0 || tmp_x >= n || tmp_y < 0 || tmp_y >= n) {
                break;
            }
            // 자기 몸과 부딪힐 시 게임 끝
            if (board[tmp_x][tmp_y] == 1) {
                break;
            }

            snake.addFirst(new Snake(tmp_x, tmp_y));

            // 사과 없을시 꼬리 삭제
            if (board[tmp_x][tmp_y] != 2) {
                Snake tail = snake.removeLast();
                board[tail.x][tail.y] = 0;
            }
            board[tmp_x][tmp_y] = 1;

            // 방향전환
            if (move[time] == 'D') {
                d += 1;
                if (d == 4) {
                    d = 0;
                }
            } else if (move[time] == 'L') {
                d -= 1;
                if (d == -1) {
                    d = 3;
                }
            }
        }
        System.out.println(time);
    }
}