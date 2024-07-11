import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, k;

    static int[] time, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[100001];
        count = new int[100001];

        Arrays.fill(time, Integer.MAX_VALUE);

        time[n] = 0;
        count[n]++;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur > 0) {
                if (time[cur - 1] > time[cur] + 1) {
                    time[cur - 1] = time[cur] + 1;
                    count[cur - 1]++;
                    q.add(cur - 1);
                } else if (time[cur - 1] == time[cur] + 1) {
                    q.add(cur - 1);
                    count[cur - 1]++;
                }
            }
            if (cur < 100000) {
                if (time[cur + 1] > time[cur] + 1) {
                    time[cur + 1] = time[cur] + 1;
                    count[cur + 1]++;
                    q.add(cur + 1);
                } else if (time[cur + 1] == time[cur] + 1) {
                    q.add(cur + 1);
                    count[cur + 1]++;
                }
            }
            if (cur * 2 <= 100000) {
                if (time[cur * 2] > time[cur] + 1) {
                    time[cur * 2] = time[cur] + 1;
                    count[cur * 2]++;
                    q.add(cur * 2);
                } else if (time[cur * 2] == time[cur] + 1) {
                    q.add(cur * 2);
                    count[cur * 2]++;
                }
            }
        }

        System.out.println(time[k]);
        System.out.println(count[k]);
    }

}