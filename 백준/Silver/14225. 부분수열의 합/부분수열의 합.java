import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;

    static int[] s;

    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        s = new int[n];
        set = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            makeSet(0, 0, 0, i);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        System.out.println(i);
    }

    static void makeSet(int cnt, int start, int sum, int end) {
        if (cnt == end) {
            set.add(sum);
            return;
        }
        for (int i = start; i < n; i++) {
            makeSet(cnt + 1, i + 1, sum + s[i], end);
        }
    }

}