import java.util.*;
import java.io.*;

class Main {

    static int T, N;
    static int[] cards;
    static int[] prefixSum;
    static int[][] dp;

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            cards = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N][N];
            prefixSum = new int[N + 1];
            for (int i = 0; i < N; i++) {
                prefixSum[i + 1] = prefixSum[i] + cards[i];
            }

            for (int length = 1; length <= N; length++) {
                for (int i = 0; i <= N - length; i++) {
                    int j = i + length - 1;

                    if (i == j) {
                        dp[i][j] = cards[i];
                        continue;
                    }

                    int sumRemainingLeft = prefixSum[j + 1] - prefixSum[i + 1];
                    int scoreIfTakeLeft = cards[i] + sumRemainingLeft - dp[i + 1][j];

                    int sumRemainingRight = prefixSum[j] - prefixSum[i];
                    int scoreIfTakeRight = cards[j] + sumRemainingRight - dp[i][j - 1];
                    
                    dp[i][j] = Math.max(scoreIfTakeLeft, scoreIfTakeRight);
                }
            }
            
            sb.append(dp[0][N-1]).append("\n");
        }
        
        System.out.print(sb);
    }
}