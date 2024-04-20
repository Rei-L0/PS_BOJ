import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t;

    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int z = 1; z <= 10; z++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                char oper = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                solve(oper, x);
            }

            sb.append("#").append(z).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solve(char o, int x) {
        int y;
        if (o == 'A') {
            for (int i = 0; i < x; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        } else if (o == 'D') {
            y = Integer.parseInt(st.nextToken());
            for (int i = 0; i < y; i++) {
                list.remove(x);
            }
        } else {
            y = Integer.parseInt(st.nextToken());
            for (int i = 0, insertIdx = x; i < y; i++, insertIdx++) {
                list.add(insertIdx, Integer.parseInt(st.nextToken()));
            }
        }
    }

}