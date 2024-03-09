import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static double ans;

    static Star[] stars;
    static int[] p;

    static PriorityQueue<Edge> pq;

    static class Star {

        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {

        int s;
        int e;
        double w;

        public Edge(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<Edge>();
        p = new int[n];
        stars = new Star[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            p[i] = i;
            stars[i] = new Star(x, y);
        }

        calcDistance();

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.s, e.e)) {
                ans += e.w;
            }
        }

        System.out.printf("%.2f%n", ans);
    }

    static void calcDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                double dx = stars[i].x - stars[j].x;
                double dy = stars[i].y - stars[j].y;
                pq.add(new Edge(i, j, Math.sqrt(dx * dx + dy * dy)));
            }
        }
    }

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        p[x] = p[y];
        return true;
    }

}