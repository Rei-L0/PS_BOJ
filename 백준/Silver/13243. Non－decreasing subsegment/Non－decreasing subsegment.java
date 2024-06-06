import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long sum = arr[i];
            int len = 1;
            for (int j = i; j < n - 1; j++) {
                if (arr[j] <= arr[j + 1]) {
                    len++;
                    sum += arr[j + 1];
                } else {
                    break;
                }
            }
            if (len > l) {
                l = len;
                ans = sum;
            }
        }

        System.out.println(l + " " + ans);
    }

}