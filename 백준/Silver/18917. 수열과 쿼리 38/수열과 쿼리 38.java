import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        long sum = 0;
        long xor = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1 || q == 2) {
                int x = Integer.parseInt(st.nextToken());
                if (q == 1) {
                    sum += x;
                    xor ^= x;
                } else {
                    sum -= x;
                    xor ^= x;
                }
            } else {
                if (q == 3) {
                    sb.append(sum).append("\n");
                } else {
                    sb.append(xor).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}