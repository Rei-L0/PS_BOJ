import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ANS;
    static int[][] A, B;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        makeArr(A);
        makeArr(B);

        if (N < 3 || M < 3) {  // 3x3 변환이 불가능한 경우
            System.out.println(isSame() ? 0 : -1);
            return;
        }

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    change(i, j);
                    ANS++;
                }
            }
        }

        // 변환이 끝난 후 A와 B가 동일한지 검사
        System.out.println(isSame() ? ANS : -1);
    }

    private static void makeArr(int[][] arr) throws IOException {
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
    }

    private static void change(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] ^= 1; // 0 <-> 1 변환
            }
        }
    }

    private static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
