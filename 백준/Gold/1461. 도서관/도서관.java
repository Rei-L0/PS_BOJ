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

    static int n, m, ans;

    static int[] books;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        books = new int[n];

        int maxDis = 0;

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            maxDis = Math.max(maxDis, Math.abs(books[i]));
            if (books[i] > 0) {
                pos.add(books[i]);
            } else {
                neg.add(books[i]);
            }
        }

        Collections.sort(pos);
        Collections.sort(neg);

        for (int i = pos.size() - 1; i >= 0; i = i - m) {
            ans += pos.get(i) * 2;
        }

        for (int i = 0; i < neg.size(); i = i + m) {
            ans += Math.abs(neg.get(i) * 2);
        }

        System.out.println(ans - maxDis);
    }

}