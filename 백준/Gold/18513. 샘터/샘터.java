import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Info> q = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int loc = Integer.parseInt(st.nextToken());
            q.offer(new Info(loc, 0));
            visit.add(loc);
        }

        long answer = 0;
        int houseCount = 0;

        while (!q.isEmpty()) {
            if (houseCount == K) {
                break;
            }
            Info now = q.poll();

            int nextUnhappiness = now.unhappiness + 1;

            int left = now.loc - 1;
            if (!visit.contains(left)) {
                visit.add(left);
                houseCount++;
                answer += nextUnhappiness;
                q.offer(new Info(left, nextUnhappiness));
                if (houseCount == K) {
                    break;
                }
            }

            int right = now.loc + 1;
            if (!visit.contains(right)) {
                visit.add(right);
                houseCount++;
                answer += nextUnhappiness;
                q.offer(new Info(right, nextUnhappiness));
                if (houseCount == K) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static class Info {

        int loc, unhappiness;

        Info(int loc, int unhappiness) {
            this.loc = loc;
            this.unhappiness = unhappiness;
        }

    }

}