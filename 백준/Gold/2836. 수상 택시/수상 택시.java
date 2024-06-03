import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static class Info {

        int s;
        int e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long ans = m;

        List<Info> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (e < s) {
                list.add(new Info(s, e));
            }
        }

        list.sort(Comparator.comparing(o -> o.e));

        int start = list.get(0).s;
        int end = list.get(0).e;

        for (Info info : list) {
            if (end < info.e) {
                ans += (end - start) * 2L;
                start = info.e;
                end = info.s;
                continue;
            }
            end = Math.max(end, info.s);
            start = Math.min(start, info.e);
        }
        ans += (end - start) * 2L;

        System.out.println(ans);

    }

}