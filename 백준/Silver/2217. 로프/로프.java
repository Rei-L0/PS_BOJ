import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n, ans = 0;
    static Integer[] w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        w = new Integer[n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(w, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            ans = Math.max(w[i] * (i + 1), ans);
        }
        System.out.println(ans);
    }
}