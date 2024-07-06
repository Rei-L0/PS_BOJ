import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int[] num = new int[5];

        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        sb.append(Arrays.stream(num).sum() / 5).append("\n")
            .append(num[2]);
        System.out.println(sb);
    }
}