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

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        Long mul = (long) (a * b * c);

        int[] arr = new int[10];

        for (char num : mul.toString().toCharArray()) {
            arr[num - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

}