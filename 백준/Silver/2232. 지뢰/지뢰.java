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

        int n = Integer.parseInt(br.readLine());

        int[] mine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            mine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            sb.append(1).append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == n) {
                    if (mine[i - 1] <= mine[i]) {
                        sb.append(i).append("\n");
                        continue;
                    }
                }
                if (mine[i - 1] <= mine[i] && mine[i] >= mine[i + 1]) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}