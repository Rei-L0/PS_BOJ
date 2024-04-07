import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int[] num;


    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            num = new int[n];
            int maxVal = 0;
            long ans = 0L;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = n - 1; j >= 0; j--) {
                if (num[j] > maxVal) {
                    maxVal = num[j];
                } else {
                    ans += maxVal - num[j];
                }
            }

            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}