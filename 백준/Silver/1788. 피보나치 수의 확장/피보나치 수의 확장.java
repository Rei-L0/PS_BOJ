import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n > 0) {
            long[] fibo = new long[n + 1];
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
                fibo[i] = (int) (fibo[i] % Math.pow(10, 9));
            }
            System.out.println(1);
            System.out.println(fibo[n]);
        } else if (n < 0) {
            n = Math.abs(n);
            long[] fibo = new long[n + 1];
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i = 0; i < n - 1; i++) {
                fibo[i + 2] = fibo[i] - fibo[i + 1];
                fibo[i + 2] = (long) (fibo[i + 2] % Math.pow(10, 9));
            }
            if (fibo[n] < 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
            System.out.println(Math.abs(fibo[n]));
        } else {
            System.out.println(0);
            System.out.println(0);
        }


    }
}