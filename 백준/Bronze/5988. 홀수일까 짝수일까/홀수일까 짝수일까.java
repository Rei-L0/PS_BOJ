import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger k = new BigInteger(br.readLine());

            if (k.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                sb.append("even").append("\n");
            } else {
                sb.append("odd").append("\n");
            }
        }

        System.out.println(sb);
    }

}