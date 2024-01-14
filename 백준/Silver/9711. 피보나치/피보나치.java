import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        long[] fibo = new long[10001];
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            fibo[0] = 0;
            fibo[1] = 1;
            if (p == 1) {
                sb.append("Case #").append(tc).append(": ").append(fibo[p] % q).append("\n");
                continue;
            }
            for (int i = 2; i < p + 1; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
                fibo[i] = fibo[i] % q;
            }
            sb.append("Case #").append(tc).append(": ").append(fibo[p]).append("\n");
        }
        System.out.print(sb);
    }
}