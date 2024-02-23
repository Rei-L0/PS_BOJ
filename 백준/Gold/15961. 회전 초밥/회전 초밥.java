import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, d, k, c, ans;

    static ArrayList<Integer> sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sushi.add(Integer.parseInt(st.nextToken()));
        }

        ans = 0;
        int cnt = 0;
        int[] count = new int[d + 1];
        for (int i = 0; i < k; i++) {
            sushi.add(sushi.get(i));
            if (count[sushi.get(i)] == 0) {
                cnt++;
            }
            count[sushi.get(i)]++;
        }

        int start = 0;
        int end = k;

        while (end != sushi.size()) {
            if (count[c] == 0) {
                cnt++;
                ans = Math.max(cnt, ans);
                cnt--;
            }
            ans = Math.max(cnt, ans);
            count[sushi.get(start)]--;
            if (count[sushi.get(start)] == 0) {
                cnt--;
            }
            start += 1;
            if (count[sushi.get(end)] == 0) {
                cnt++;
            }
            count[sushi.get(end)]++;
            end += 1;
        }
        System.out.println(ans);
    }
}