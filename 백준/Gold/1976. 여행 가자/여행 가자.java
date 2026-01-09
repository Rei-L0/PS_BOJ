import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[N][N];

        int[] plans = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i][j] = true;
                    arr[j][i] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        floydWarshall(arr, N);

        for (int i = 1; i < M; i++) {
            int s = plans[i - 1];
            int e = plans[i];
            if (!arr[s - 1][e - 1]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void floydWarshall(boolean[][] arr, int N) {
        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (s == e) {
                        arr[s][e] = true;
                        continue;
                    }
                    if (arr[s][k] && arr[k][e]) {
                        arr[s][e] = true;
                    }
                }
            }
        }
    }
}