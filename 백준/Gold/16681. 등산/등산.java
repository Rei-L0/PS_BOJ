import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, d, e;

    static long ans = Long.MIN_VALUE;

    static int[] h;
    static long[] upDis, downDis;

    static List<List<Edge>> graph;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge> {

        int to;
        int h;
        long w;

        public Edge(int to, int h, long w) {
            this.to = to;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        h = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        upDis = new long[n + 1];
        downDis = new long[n + 1];

        Arrays.fill(upDis, Long.MAX_VALUE);
        Arrays.fill(downDis, Long.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, h[b], w));
            graph.get(b).add(new Edge(a, h[a], w));
        }

        up();
        down();

        for (int i = 1; i < n; i++) {
            if (upDis[i] == Long.MAX_VALUE || downDis[i] == Long.MAX_VALUE) {
                continue;
            }
            ans = Math.max(((long) h[i] * e) - ((upDis[i] + downDis[i]) * d), ans);
        }
        System.out.println((ans == Long.MIN_VALUE) ? "Impossible" : ans);
    }

    static void up() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 1, 0));
        upDis[1] = 0;

        dijk((PriorityQueue<Edge>) pq, upDis);
    }

    static void down() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(n, 1, 0));
        downDis[n] = 0;

        dijk(pq, downDis);
    }

    private static void dijk(PriorityQueue<Edge> pq, long[] worth) {
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.w > worth[now.to]) {
                continue;
            }
            for (Edge next : graph.get(now.to)) {
                if (worth[next.to] > now.w + next.w && now.h < next.h) {
                    worth[next.to] = now.w + next.w;
                    pq.add(new Edge(next.to, h[next.to], worth[next.to]));
                }
            }
        }
    }
}