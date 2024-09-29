import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ans[s][e] = -1;
            ans[e][s] = 1;
        }

        for (int i = 1; i <= n; i++) {
            solve(i);
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(ans[s][e]).append("\n");
        }

        System.out.println(sb);
    }

    static void solve(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (ans[now][i] == -1 && !visited[i]) {
                    ans[start][i] = -1;
                    ans[i][start] = 1;
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}

