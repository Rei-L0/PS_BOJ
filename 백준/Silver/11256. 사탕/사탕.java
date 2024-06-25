import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[i] = r * c;
            }

            Arrays.sort(arr, Collections.reverseOrder());
            int ans = 0;
            for (Integer i : arr) {
                j -= i;
                ans++;
                if (j <= 0) {
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}