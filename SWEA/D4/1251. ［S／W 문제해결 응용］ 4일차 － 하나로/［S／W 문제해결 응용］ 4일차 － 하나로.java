import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int t, n;

    static int[] p;
    static int[] size;
    static int[][] island;
    static PriorityQueue<Node> pq;

    static double ans;

    static void calcDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                long dx = Math.abs(island[i][0] - island[j][0]);
                long dy = Math.abs(island[i][1] - island[j][1]);
                pq.add(new Node(i, j,
                    dx * dx + dy * dy));
            }
        }
    }

    static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        int pX = find(x);
        int pY = find(y);

        if (pX == pY) {
            return false;
        }
        if (size[pX] > size[pY]) {
            size[pX] += size[pY];
            p[pY] = p[pX];
        } else {
            size[pY] += size[pX];
            p[pX] = p[pY];
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>();

            ans = 0;
            island = new int[n][n];
            p = new int[n];
            size = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
                p[i] = i;
                size[i] = 1;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }

            calcDistance();

            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (union(now.s, now.e)) {
                    ans += now.w;
                }

            }
            System.out.println("#" + tc + " " + String.format("%.0f", ans * a));
        }
    }

    static class Node implements Comparable<Node> {

        int s;
        int e;
        long w;

        public Node(int s, int e, long w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
}