import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Solution {

    static int t, n, m, k, a, b, ans;

    static int[] in, repair, time;

    static void solve() {
        int[][] res = new int[k + 1][2];
        Info[] first = new Info[n + 1];
        Info[] second = new Info[m + 1];
        ArrayDeque<Integer> p = new ArrayDeque<>();
        ArrayDeque<Integer> next = new ArrayDeque<>();
        ArrayDeque<Integer> finish = new ArrayDeque<>();

        for (int i = 1; i <= k; i++) {
            p.add(i);
        }

        int time = 0;
        while (finish.size() != k) {
            // 접수 창고 비었을 시 사람 도착 여부 확인 후 배정
            // 정비 창구 이동 여부 확인
            for (int i = 1; i < first.length; i++) {
                if (first[i] != null) {
                    first[i].time--;
                    if (first[i].time == 0) {
                        next.add(first[i].num);
                        first[i] = null;
                    }
                }
            }
            // 고객의 조건 일치 여부
            for (int i = 1; i < second.length; i++) {
                if (second[i] != null) {
                    second[i].time--;
                    if (second[i].time == 0) {
                        second[i] = null;
                        finish.add(i);
                    }
                }
            }
            check(res, first, p, time);
            if (!next.isEmpty()) {
                for (int i = 1; i < second.length; i++) {
                    if (next.isEmpty()) {
                        break;
                    }
                    if (second[i] == null) {
                        int pNum = next.poll();
                        second[i] = new Info(repair[i], pNum);
                        res[pNum][1] = i;
                    }
                }
            }
            time++;
        }

        for (int i = 1; i < res.length; i++) {
            if (res[i][0] == a && res[i][1] == b) {
                ans += i;
            }
        }
    }

    private static void check(int[][] res, Info[] arr, ArrayDeque<Integer> q, int x) {
        if (!q.isEmpty()) {
            for (int i = 1; i < arr.length; i++) {
                if (q.isEmpty()) {
                    break;
                }
                if (arr[i] == null && time[q.peek()] <= x) {
                    int pNum = q.poll();
                    arr[i] = new Info(in[i], pNum);
                    res[pNum][0] = i;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 초기화
            ans = 0;
            in = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            repair = new int[m + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                repair[i] = Integer.parseInt(st.nextToken());
            }

            time = new int[k + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 문제 해결
            solve();
            // 결과 출력
            sb.append("#").append(tc).append(" ").append((ans == 0) ? -1 : ans).append("\n");
        }
        System.out.println(sb);
    }

    static class Info {

        int time;
        int num;

        public Info(int time, int num) {
            this.time = time;
            this.num = num;
        }
    }


}