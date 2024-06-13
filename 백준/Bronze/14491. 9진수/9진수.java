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

        while (n != 0) {
            sb.append(n % 9);
            n /= 9;
        }

        System.out.println(sb.reverse());

    }

}