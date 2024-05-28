import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] relation = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            relation[s][e] = true;
            relation[e][s] = true;
        }

        int ans = 0, val = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (val > bfs(i, n, relation)) {
                val = bfs(i, n, relation);
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int bfs(int s, int n, boolean[][] relation) {
        int[] visit = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (i == s) {
                    continue;
                }
                if (relation[cur][i] && visit[i] == 0) {
                    visit[i] = visit[cur] + 1;
                    q.add(i);
                }
            }
        }

        return Arrays.stream(visit).sum();
    }
}