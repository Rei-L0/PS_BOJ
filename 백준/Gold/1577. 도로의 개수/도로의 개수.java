import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static class Pos {

        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Pos, ArrayList<Pos>> map = new HashMap<>();

        long[][] dp = new long[m + 1][n + 1];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Pos s = new Pos(y1, x1);
            Pos e = new Pos(y2, x2);

            pushMap(map, s, e);
            pushMap(map, e, s);
        }

        dp[0][0] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                boolean checkL = false;
                boolean checkD = false;
                Pos now = new Pos(i, j);
                Pos left = new Pos(i, j - 1);
                Pos down = new Pos(i - 1, j);
                if (map.containsKey(now)) {
                    for (Pos next : map.get(now)) {
                        if (next.equals(left)) {
                            checkL = true;
                        }
                        if (next.equals(down)) {
                            checkD = true;
                        }
                    }
                }
                if (!checkL && j != 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (!checkD && i != 0) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[m][n]);
    }

    private static void pushMap(HashMap<Pos, ArrayList<Pos>> map, Pos s, Pos e) {
        if (map.containsKey(s)) {
            ArrayList<Pos> list = map.get(s);
            list.add(e);
        } else {
            ArrayList<Pos> list = new ArrayList<>();
            list.add(e);
            map.put(s, list);
        }
    }

}