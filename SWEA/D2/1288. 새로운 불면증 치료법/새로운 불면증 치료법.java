import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        int check = (1 << 10) - 1;

        for (int z = 1; z <= t; z++) {
            n = Integer.parseInt(br.readLine());

            int visit = 0;
            int count = 0;

            for (count = 1; ; count++) {
                char[] num = String.valueOf(n * count).toCharArray();

                for (char c : num) {
                    visit = visit | (1 << (c - '0'));
                }

                if (visit == check) {
                    break;
                }
            }
            sb.append("#").append(z).append(" ").append(n * count).append("\n");
        }
        System.out.print(sb);
    }
}