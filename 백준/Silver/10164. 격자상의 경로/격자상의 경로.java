import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int num = 1, tx = 0, ty = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (num++ == K) {
                    tx = i;
                    ty = j;
                }
            }
        }

        System.out.println(checkBranch(0, 0, tx, ty) * checkBranch(tx, ty, N - 1, M - 1));
    }

    static int checkBranch(int sx, int sy, int ex, int ey) {
        int[][] cnt = new int[N][M];
        cnt[sx][sy] = 1;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                for (int d = 0; d < 2; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < N && ny < M) {
                        cnt[nx][ny] += cnt[i][j];
                    }
                }
            }
        }
        return cnt[ex][ey];
    }
}