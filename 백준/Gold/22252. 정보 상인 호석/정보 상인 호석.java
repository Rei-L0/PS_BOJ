import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 22252 정보 상인 호석
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, PriorityQueue<Integer>> info = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            // 쿼리가 1일 경우
            if (q == 1) {
                // k개의 정보를 heap에 추가한다.
                for (int j = 0; j < k; j++) {
                    // Hashmap에 key값이 없을 경우 생성 후 추가
                    if (!info.containsKey(name)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(Integer.parseInt(st.nextToken()));
                        info.put(name, pq);
                    }
                    // key값이 있을 경우 기존 heap에 정보 추가
                    else {
                        info.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            // 쿼리가 2일 경우
            else {
                if (info.get(name) == null) {
                    continue;
                }
                while (!info.get(name).isEmpty() && k > 0) {
                    ans += info.get(name).poll();
                    k -= 1;
                }
            }
        }
        System.out.println(ans);
    }
}