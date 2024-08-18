import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        AtomicLong ans = new AtomicLong();
        AtomicInteger cnt = new AtomicInteger();

        map.forEach((key, value) -> {
            if (cnt.get() < value) {
                cnt.set(value);
                ans.set(key);
            } else if (cnt.get() == value) {
                if (ans.get() > key) {
                    ans.set(key);
                }
            }
        });

        System.out.println(ans.get());
    }

}