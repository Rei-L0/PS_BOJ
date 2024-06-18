import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, a, b;

    static List<List<Edge>> list;

    static class Edge {

        int v;
        long w;
        int max;

        public Edge(int v, long w, int max) {
            this.v = v;
            this.w = w;
            this.max = max;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new Edge(e, w, 0));
            list.get(e).add(new Edge(s, w, 0));
        }

        System.out.println(solve(a, b));
    }

    static long solve(int start, int end) {
        long[] distance = new long[n + 1];
        boolean[] visited = new boolean[n + 1];

        int max = 0;

        Queue<Edge> q = new ArrayDeque<>();
        q.add(new Edge(start, 0, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            if (edge.v == end) {
                max = edge.max;
                break;
            }
            for (Edge e : list.get(edge.v)) {
                if (visited[e.v]) {
                    continue;
                }
                visited[e.v] = true;
                distance[e.v] += e.w + edge.w;
                q.offer(new Edge(e.v, distance[e.v], (int) Math.max(edge.max, e.w)));
            }
        }
        return distance[end] - max;
    }


}