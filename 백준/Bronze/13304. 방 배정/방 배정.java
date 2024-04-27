import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] room = new int[3][2];

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int sung = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int hak = (h - 1) / 2;

            if (hak == 0) {
                if (room[hak][0] == k) {
                    room[hak][0] = 0;
                }
                if (room[hak][0] == 0) {
                    ans++;
                }
                room[hak][0]++;
            } else {
                if (room[hak][sung] == k) {
                    room[hak][sung] = 0;
                }
                if (room[hak][sung] == 0) {
                    ans++;
                }
                room[hak][sung]++;
            }
        }

        System.out.println(ans);
    }

}