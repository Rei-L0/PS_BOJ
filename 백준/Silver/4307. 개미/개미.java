import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, l, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int[] ant = new int[n];
            for (int i = 0; i < n; i++) {
                ant[i] = Integer.parseInt(br.readLine());
            }

            int min = 0;
            int max = Integer.MIN_VALUE;

            Arrays.sort(ant);

            for (int i = 0; i < n; i++) {
                int nowMin = Math.min(ant[i], l - ant[i]);
                int nowMax = Math.max(ant[i], l - ant[i]);
                min = Math.max(min, nowMin);
                max = Math.max(max, nowMax);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}