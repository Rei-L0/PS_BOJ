import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000;

    static int t, n;

    static int[] p, dis;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int z = 0; z < t; z++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            p = new int[n + 1];
            dis = new int[n + 1];

            for (int i = 0; i < n; i++) {
                p[i] = i;
            }

            while (true) {
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                if (oper == 'O') {
                    break;
                } else if (oper == 'E') {
                    int num = Integer.parseInt(st.nextToken());
                    find(num);
                    sb.append(dis[num]).append("\n");
                } else {
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    p[i] = j;
                    dis[i] = Math.abs(i - j) % MOD;
                }
            }
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        int tmp = find(p[x]);
        dis[x] += dis[p[x]];
        p[x] = tmp;
        return p[x];
    }

}