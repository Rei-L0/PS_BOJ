import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m, ans;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static char[][] arr;

    static Set<String> check = new HashSet<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '#') {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int bx = i - dx[k];
                    int by = j - dy[k];
                    if (bx < 0 || bx >= n || by < 0 || by >= m || arr[bx][by] == '#') {
                        if (bfs(i, j, k).length() > 1) {
                            list.add(bfs(i, j, k));
                        }
                    }
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }

    static String bfs(int x, int y, int d) {
        StringBuilder stringBuilder = new StringBuilder();
        while (isIn(x, y) && arr[x][y] != '#') {
            stringBuilder.append(arr[x][y]);
            x = x + dx[d];
            y = y + dy[d];
        }
        return stringBuilder.toString();
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}