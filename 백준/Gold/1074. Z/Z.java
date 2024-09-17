import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve((int) Math.pow(2, N), r, c, 0);
        System.out.println(ans);
    }

    static void solve(int n, int r, int c, int cnt) {
        if (n == 1) {
            ans = cnt;
            return;
        }
        int next = n / 2;
        int nR = r % next;
        int nC = c % next;
        solve(next, nR, nC, cnt + (next * next * ((r / next) * 2 + c / next)));
    }

}