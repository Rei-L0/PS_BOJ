import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int[] ans, num;
    static Ball[] balls;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Ball implements Comparable<Ball> {

        int num;
        int c;
        int s;

        public Ball(int num, int c, int s) {
            this.num = num;
            this.c = c;
            this.s = s;
        }

        @Override
        public int compareTo(Ball o) {
            if (this.s == o.s) {
                return Integer.compare(this.c, o.c);
            }
            return Integer.compare(this.s, o.s);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        balls = new Ball[n];
        ans = new int[n + 1];
        num = new int[n + 1];

        int res = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i + 1, c, s);
        }

        Arrays.sort(balls);

        int val = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Ball b = balls[i];
            res += b.s;
            num[b.c] += b.s;
            if (val != b.s) {
                val = b.s;
                cnt = 0;
            } else {
                cnt++;
            }
            if (i != 0 && b.c == balls[i - 1].c && b.s == balls[i - 1].s) {
                ans[b.num] = ans[balls[i - 1].num];
            } else if (i != 0 && b.s == balls[i - 1].s) {
                ans[b.num] += res - num[b.c] - (cnt * b.s);
            } else {
                ans[b.num] += res - num[b.c];
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
}