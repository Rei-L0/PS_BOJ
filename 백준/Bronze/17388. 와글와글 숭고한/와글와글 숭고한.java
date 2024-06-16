import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        if (s + k + h >= 100) {
            sb.append("OK").append("\n");
        } else {
            if (s < k && s < h) {
                sb.append("Soongsil").append("\n");
            }
            if (k < s && k < h) {
                sb.append("Korea").append("\n");
            }
            if (h < k && h < s) {
                sb.append("Hanyang").append("\n");
            }
        }

        System.out.print(sb);
    }

}