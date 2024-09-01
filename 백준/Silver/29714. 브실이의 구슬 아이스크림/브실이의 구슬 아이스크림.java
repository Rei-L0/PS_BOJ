import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static long[] h, p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int numA = Integer.parseInt(st.nextToken());
            boolean flag = true;
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int j = 0; j < numA; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (tmpMap.containsKey(num)) {
                    tmpMap.put(num, tmpMap.get(num) + 1);
                } else {
                    tmpMap.put(num, 1);
                }
            }
            for (int key : tmpMap.keySet()) {
                if (!map.containsKey(key)) {
                    flag = false;
                    break;
                }
                if (map.get(key) < tmpMap.get(key)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int key : tmpMap.keySet()) {
                    map.put(key, map.get(key) - tmpMap.get(key));
                }
            }
            st = new StringTokenizer(br.readLine());
            int numB = Integer.parseInt(st.nextToken());
            if (flag) {
                for (int j = 0; j < numB; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                ans.add(key);
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.print(sb);
    }
}