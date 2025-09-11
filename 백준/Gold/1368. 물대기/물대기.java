import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) { 
            adj.add(new ArrayList<>());
        }

        int virtualNode = N;

        for (int i = 0; i < N; i++) {
            int wellCost = Integer.parseInt(br.readLine());
            adj.get(i).add(new Edge(virtualNode, wellCost));
            adj.get(virtualNode).add(new Edge(i, wellCost));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int connectionCost = Integer.parseInt(st.nextToken());
                if (i < j) {
                    adj.get(i).add(new Edge(j, connectionCost));
                    adj.get(j).add(new Edge(i, connectionCost));
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        
        long totalCost = 0;
        int nodeCount = 0;

        pq.offer(new Edge(virtualNode, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if (visited[current.to]) {
                continue;
            }

            visited[current.to] = true;
            totalCost += current.cost;
            nodeCount++;

            if (nodeCount == N + 1) {
                break;
            }
            
            for (Edge next : adj.get(current.to)) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }
        
        System.out.println(totalCost);
    }
}