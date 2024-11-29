import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        System.out.println(prim(graph, V));
    }

    static long prim(List<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0)); // 임의의 시작점 (1번 노드)

        long totalWeight = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.node]) continue;

            visited[current.node] = true;
            totalWeight += current.weight;
            edgesUsed++;

            if (edgesUsed == V) break;

            for (Edge neighbor : graph[current.node]) {
                if (!visited[neighbor.node]) {
                    pq.add(neighbor);
                }
            }
        }

        return totalWeight;
    }
}
