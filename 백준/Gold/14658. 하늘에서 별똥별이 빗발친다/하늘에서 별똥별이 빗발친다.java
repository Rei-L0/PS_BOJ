import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static int n, m, l, k, ans;

    static Pos[] stars;

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stars = new Pos[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i] = new Pos(x, y);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                ans = Math.max(ans, check(stars[i].x, stars[j].y));
            }
        }
        System.out.println(k - ans);

    }


    static int check(int sx, int sy) {
        int ex = sx + l;
        int ey = sy + l;
        int cnt = 0;
        for (Pos star : stars) {
            if (sx <= star.x && sy <= star.y && star.x <= ex && star.y <= ey) {
                cnt++;
            }
        }
        return cnt;
    }

}