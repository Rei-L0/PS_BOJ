import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        List<Integer>[] graphs = new ArrayList[n + 1];
        for (int i = 0; i < graphs.length; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graphs[e].add(s);
        }

        int x = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        int ans = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graphs[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}