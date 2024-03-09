import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    static char[] s;
    static int[] parent;
    static PriorityQueue<Edge> edges = new PriorityQueue<Edge>();


    static class Edge implements Comparable<Edge> {

        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = new char[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            s[i] = st.nextToken().charAt(0);
        }

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (s[u] == s[v]) {
                continue;
            }
            edges.add(new Edge(u, v, w));
        }

        System.out.println(solve());

    }

    static int solve() {
        int count = 0;
        int res = 0;
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            if (union(e.u, e.v)) {
                count++;
                res += e.w;
            }
        }

        if (count == (n - 1)) {
            return res;
        } else {
            return -1;
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        parent[x] = parent[y];
        return true;
    }

}