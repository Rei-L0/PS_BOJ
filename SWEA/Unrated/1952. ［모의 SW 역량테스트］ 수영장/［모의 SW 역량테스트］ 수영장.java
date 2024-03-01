import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int N = 12;

    static int t, day, month, three, year, ans;
    static int[] plan;

    static BufferedReader bReader;
    static StringTokenizer st;

    static void init() throws Exception {
        st = new StringTokenizer(bReader.readLine());
        day = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());
        three = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());

        plan = new int[N];
        ans = year;
        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < N; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

    }

    // 1일권, 1달권, 3달권, 1년권 차례로 비교
    static void solve(int m, int c) {
        if (m >= N) {
            ans = Math.min(ans, c);
            return;
        }
        solve(m + 1, c + (day * plan[m]));
        solve(m + 1, c + month);
        solve(m + 3, c + three);
    }

    public static void main(String[] args) throws Exception {
        bReader = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bReader.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++) {
            init();
            solve(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }
}