import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static class Info {

        int s;
        int e;
        int cnt;

        public Info(int s, int e, int cnt) {
            this.s = s;
            this.e = e;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(solve(s, e)).append("\n");
        }

        System.out.print(sb);
    }

    static int solve(int s, int e) {
        int ans = e - s;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cnt));
        pq.offer(new Info(s, e, 0));
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (info.s == info.e) {
                ans = Math.min(ans, info.cnt);
            }
            if (info.cnt >= ans) {
                continue;
            }
            if (info.s * 2 <= info.e + 3) {
                pq.add(new Info(info.s * 2, info.e + 3, info.cnt + 1));
            }
            pq.add(new Info(info.s + 1, info.e, info.cnt + 1));
        }
        return ans;
    }
}