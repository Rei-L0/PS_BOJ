import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] count = new int[100001];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 100001; i++) {
            if (count[i] == 0) {
                count[i] = 1;
                primes.add(i);
                for (int j = i * 2; j < 100001; j = j + i) {
                    count[j] = -1;
                }
            }
        }

        for (int i = 2; i < 100001; i++) {
            if (count[i] == -1) {
                for (int prime : primes) {
                    if (i % prime == 0) {
                        count[i] = count[i / prime] + 1;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (count[count[i]] == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}