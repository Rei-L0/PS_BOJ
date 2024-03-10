import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static double ans;

    static Pos[] pos;

    static int[] p;

    static PriorityQueue<Edge> edges = new PriorityQueue<Edge>();

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
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
        m = Integer.parseInt(st.nextToken());

        pos = new Pos[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = i;
            pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        makeEdges();

        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            if (union(e.s, e.e)) {
                ans += e.w;
            }
        }

        System.out.printf("%.2f\n", ans);
    }

    static double calc(int x, int y, int ex, int ey) {
        long dx = (long) Math.abs(x - ex);
        long dy = (long) Math.abs(y - ey);
        return Math.sqrt(dx * dx + dy * dy);
    }

    static void makeEdges() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges.add(new Edge(i, j, calc(pos[i].x, pos[i].y, pos[j].x, pos[j].y)));
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