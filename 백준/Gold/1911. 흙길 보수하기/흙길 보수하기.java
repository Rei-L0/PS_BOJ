import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static class Info implements Comparable<Info> {

        int s;
        int e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            if (this.s == o.s) {
                return Integer.compare(this.e, o.e);
            }
            return Integer.compare(this.s, o.s);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Info(s, e));
        }

        Collections.sort(list);

        int ans = 0;
        int end = 0;

        for (Info info : list) {
            if (info.s > end) {
                end = info.s;
            }
            if (info.e >= end) {
                while (info.e > end) {
                    end += l;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}