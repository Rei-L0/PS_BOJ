import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dis = new int[N + 1];
        Arrays.fill(dis, -1);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dis[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dis[next] == -1) {
                    dis[next] = dis[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        int maxVal = 0;
        int num = 0;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (dis[i] != -1) {
                if (dis[i] > maxVal) {
                    maxVal = dis[i];
                    num = i;
                    cnt = 1;
                } else if (dis[i] == maxVal) {
                    cnt++;
                }
            }

        }

        sb.append(num).append(" ").append(maxVal).append(" ").append(cnt).append("\n");
        System.out.println(sb);
    }
}