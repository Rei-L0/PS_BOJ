import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static long[] h, p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        h = new long[N + 1];
        p = new long[N + 1];
        h[0] = p[0] = 1;
        for (int i = 1; i <= N; i++) {
            h[i] = h[i - 1] * 2 + 3;
            p[i] = p[i - 1] * 2 + 1;
        }
        long answer = cal(N, x);
        br.close();
        System.out.println(answer + "");
    }

    static long cal(int level, long count) {
        if (level == 0) {
            if (count == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        if (count == 0) {
            return 0;
        } else if (h[level - 1] + 2 == count) {
            return p[level - 1] + 1;
        } else if (h[level - 1] + 2 > count) {
            return cal(level - 1, count - 1);
        } else if (h[level - 1] + 2 < count) {
            return p[level - 1] + 1 + cal(level - 1, count - h[level - 1] - 2);
        } else {
            return p[level];
        }
    }
}