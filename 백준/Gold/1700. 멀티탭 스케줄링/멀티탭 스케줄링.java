import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;

    static int[] multi, num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        multi = new int[n];

        num = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            if (check(num[i])) {
                ans++;
                multi[solve(i)] = num[i];
            }
        }

        System.out.println(ans);
    }

    static boolean check(int x) {
        for (int i = 0; i < n; i++) {
            if (multi[i] == 0 || multi[i] == x) {
                multi[i] = x;
                return false;
            }
        }
        return true;
    }

    static int solve(int x) {
        int res = n;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = x; j < k; j++) {
                if (multi[i] == num[j]) {
                    if (idx < j) {
                        idx = j;
                        res = i;
                    }
                    break;
                }
            }
            if (j == k) {
                res = i;
                idx = j + 1;
            }
        }
        return res;
    }

}