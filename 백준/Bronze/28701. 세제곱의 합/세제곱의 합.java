import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans1 = 0;
        int ans2 = 0;
        for (int i = 1; i <= n; i++) {
            ans1 += i;
            ans2 += (int) Math.pow(i, 3);
        }

        System.out.println(ans1);
        System.out.println((int) Math.pow(ans1, 2));
        System.out.println(ans2);
    }

}