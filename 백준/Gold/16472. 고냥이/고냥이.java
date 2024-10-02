import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int ans = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        while (end + 1 < s.length()) {
            if (map.size() <= n) {
                ans = Math.max(end - start + 1, ans);
                end++;
                char now = s.charAt(end);
                map.put(now, map.getOrDefault(now, 0) + 1);
            } else {
                char now = s.charAt(start);
                if (map.get(now) == 1) {
                    map.remove(now);
                } else {
                    map.put(now, map.get(now) - 1);
                }
                start++;
            }
        }

        // 마지막 상태에서 최종 길이 비교
        if (map.size() <= n) {
            ans = Math.max(end - start + 1, ans);
        }

        System.out.println(ans);
    }
}
