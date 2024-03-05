import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int t, n, k, id, m;

    static ArrayList<Team> list;

    static class Team implements Comparable<Team> {

        int num;
        int score;
        int count;
        int time;
        int[] problem;

        public Team(int num, int score, int count, int time) {
            this.num = num;
            this.score = score;
            this.count = count;
            this.time = time;
            problem = new int[k + 1];
            Arrays.fill(problem, -1);
        }

        @Override
        public int compareTo(Team o) {
            if (this.score == o.score) {
                if (this.count == o.count) {
                    return Integer.compare(this.time, o.time);
                }
                return Integer.compare(this.count, o.count);
            }
            return Integer.compare(o.score, this.score);
        }
    }

    static void solve(int x, int y, int score, int time) {
        Team now = list.get(x);
        // 이미 해당 문제를 풀었을 때
        if (now.problem[y] != -1) {
            if (score > now.problem[y]) {
                now.score -= now.problem[y];
                now.problem[y] = score;
                now.score += score;
            }
        }
        // 풀지 않았을 때
        else {
            now.problem[y] = score;
            now.score += score;
        }
        now.count++;
        now.time = time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            id = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(new Team(j, 0, 0, 0));
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int tId = Integer.parseInt(st.nextToken());
                int pNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                solve(tId - 1, pNum, score, j + 1);
            }

            Collections.sort(list);

            for (int x = 0; x < list.size(); x++) {
                if (list.get(x).num == id - 1) {
                    System.out.println(x + 1);
                    break;
                }
            }
        }
    }
}