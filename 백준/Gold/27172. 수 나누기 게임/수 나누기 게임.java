import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        int[] ans = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = num * 2; j < 1_000_001; j += num) {
                if (map.containsKey(j)) {
                    ans[i]++;
                    ans[map.get(j)]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

}