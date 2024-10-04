import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] ans = new boolean[51];
        int[] arr = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (ans[num]) {
                q.offer(num);
            }
            ans[num] = true;
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now + k > n) {
                continue;
            }
            if (ans[now + k]) {
                q.offer(now + k);
            } else {
                ans[now + k] = true;
            }
        }

        System.out.println(solve(ans));
    }

    static int solve(boolean[] arr) {
        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                return 0;
            }
        }
        return 1;
    }
}
