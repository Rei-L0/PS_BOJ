import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int M = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
