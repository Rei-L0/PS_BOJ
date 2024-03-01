import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 16933
public class Solution {

    static int t, n, m, c, ans;

    static int[][] map;

    static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + m - 1 >= n) {
                    continue;
                }
                // a의 꿀
                int a = calc(i, j, j + m);

                for (int x = i; x < n; x++) {
                    if (x == i) {
                        for (int y = j + m; y < n; y++) {
                            if (y + m - 1 >= n) {
                                continue;
                            }
                            // b의 꿀
                            int b = calc(x, y, y + m);
                            // a+b와 이 때까지의 결과중 최대값 저장
                            ans = Math.max(ans, a + b);
                        }
                    } else {
                        for (int y = 0; y < n; y++) {
                            if (y + m - 1 >= n) {
                                continue;
                            }
                            // b의 꿀
                            int b = calc(x, y, y + m);
                            // a+b와 이 때까지의 결과중 최대값 저장
                            ans = Math.max(ans, a + b);
                        }
                    }
                }
            }
        }
    }

    static int calc(int r, int s, int e) {
        int res = 0;
        int[] arr = new int[m];
        int index = 0;
        for (int i = s; i < e; i++) {
            arr[index++] = map[r][i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            combi(0, 0, i, new int[i], arr, list);
        }
        return Collections.max(list);
    }

    static void combi(int start, int count, int end, int[] res, int[] arr,
        ArrayList<Integer> list) {
        if (count == end) {
            int honey = 0;
            int cnt = 0;
            for (int i = 0; i < res.length; i++) {
                cnt += res[i];
                honey += res[i] * res[i];
            }
            if (cnt <= c) {
                list.add(honey);
            }
            return;
        }
        for (int i = start; i < m; i++) {
            res[count] = arr[i];
            combi(i + 1, count + 1, end, res, arr, list);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++) {
            // 초기화 및 입력 받기
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            ans = 0;
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 문제 해결
            solve();
            // 출력
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}