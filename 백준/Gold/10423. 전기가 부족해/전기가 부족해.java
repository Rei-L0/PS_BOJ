import java.io.*;
import java.util.*;

class Main {

    static StringTokenizer st;
    static int N, M, K, cnt, ans;

    static PriorityQueue<Edge> pq;
    static boolean[] visited;

    static List<Edge>[] graph;

    static class Edge implements Comparable<Edge> {

        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        pq = new PriorityQueue<>();
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(k, 0));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.node]) {
                continue;
            }

            visited[now.node] = true;
            ans += now.weight;
            cnt++;

            if (cnt == N) {
                break;
            }

            for (Edge next : graph[now.node]) {
                if (!visited[next.node]) {
                    pq.offer(next);
                }
            }

        }

        System.out.println(ans);

    }
}