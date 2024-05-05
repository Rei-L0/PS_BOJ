import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] num = new int[n + 1];
        int[] arr = new int[n + 1];

        int ans = n + 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            arr[i] = (arr[i - 1] + num[i]);
        }

        for (int start = 1; start <= n; start++) {
            int end = Math.min(n, start + ans);
            while (start <= end) {
                if (arr[end] - arr[start - 1] >= c) {
                    ans = Math.min(ans, end - start + 1);
                    end--;
                } else {
                    break;
                }
            }
        }

        System.out.println((ans == n + 1) ? 0 : ans);
    }

}