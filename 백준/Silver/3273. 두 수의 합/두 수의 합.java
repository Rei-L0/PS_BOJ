import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(data);
        int ans = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (data[start] + data[end] == x) {
                ans += 1;
                end -= 1;
            } else if (data[start] + data[end] > x) {
                end -= 1;
            } else {
                start += 1;
            }
        }

        System.out.println(ans);

    }
}