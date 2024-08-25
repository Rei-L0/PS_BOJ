import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 0;

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[i] = k;
            end = Math.max(end, k);
        }

        int max = 0;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i] % mid == 0) {
                    sum += arr[i] / mid;
                } else {
                    sum += (arr[i] / mid) + 1;
                }
            }

            if (sum > n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}