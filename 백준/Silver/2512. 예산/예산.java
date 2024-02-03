import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 2512
public class Main {

    static int n, m, ans = 0;
    static int[] money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        money = new int[n];
        int start = 1;
        int end = 0;
        int check = 0;

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(stringTokenizer.nextToken());
            check += money[i];
            if (end < money[i]) {
                end = money[i];
            }
        }
        stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        if (check > m) {
            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (mid < money[i]) {
                        sum += mid;
                    } else {
                        sum += money[i];
                    }
                }
                if (sum > m) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println(end);
    }
}