import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 5;

    static StringTokenizer st;
    static StringBuilder sb;

    static int ans = Integer.MAX_VALUE;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] map = new int[SIZE][SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < SIZE; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < SIZE; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        solve(x, y, 0, 0, map);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void solve(int x, int y, int appleCount, int moveCount, int[][] arr) {
        if (appleCount == 3) {
            ans = Math.min(ans, moveCount);
            return;
        }
        if (moveCount > ans) {
            return;
        }

        int[][] arrCopy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(arr[i], 0, arrCopy[i], 0, SIZE);
        }
        arrCopy[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nowAppleCount = appleCount;
            if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE || arr[nx][ny] == -1) {
                continue;
            }
            if (arr[nx][ny] == 1) {
                nowAppleCount++;
            }
            solve(nx, ny, nowAppleCount, moveCount + 1, arrCopy);
        }
    }

}