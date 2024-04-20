import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int z = 1; z <= t; z++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append("#").append(z).append(" ")
                .append(((m & (1 << n) - 1) == (1 << n) - 1) ? "ON" : "OFF").append("\n");
        }
        System.out.print(sb);
    }
}