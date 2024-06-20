import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static class Function implements Comparable<Function> {

        int a;
        int b;

        public Function(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Function o) {
            if (this.a == o.a) {
                return Integer.compare(this.b, o.b);
            }
            return Integer.compare(this.a, o.a);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long ans = 0;

        List<Function> funcs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            funcs.add(new Function(a, b));
        }

        Collections.sort(funcs);

        for (int i = 0; i < n; i++) {
            Function f = funcs.get(i);
            ans += ((long) f.a * (i + 1)) + f.b;
        }

        System.out.println(ans);
    }

}