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

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        int[] degrees = new int[n + 1];
        int[] time = new int[n + 1];
        int[] finish = new int[n + 1];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            time[i] = cost;
            int degreeCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < degreeCount; j++) {
                int next = Integer.parseInt(st.nextToken());
                degrees[i]++;
                graph.get(next).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                q.add(i);
                finish[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer next : graph.get(now)) {
                degrees[next]--;
                finish[next] = Math.max(finish[next], finish[now] + time[next]);
                if (degrees[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, finish[i]);
        }

        System.out.println(ans);
    }

}