import java.io.*;
import java.util.*;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1명 ~ N/2명까지 팀 구성 가능
        for (int i = 1; i <= N / 2; i++) {
            comb(0, 0, i);
        }

        System.out.println(min);
    }

    static void comb(int idx, int depth, int teamSize) {
        if (depth == teamSize) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        start += S[i][j] + S[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += S[i][j] + S[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(i + 1, depth + 1, teamSize);
                visited[i] = false;
            }
        }
    }
}