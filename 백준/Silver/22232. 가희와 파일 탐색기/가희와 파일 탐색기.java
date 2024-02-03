import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            set.add(br.readLine());
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(list.get(i), ".");
            String front = stringTokenizer.nextToken();
            String back = stringTokenizer.nextToken();
            int flag = 0;
            if (set.contains(back)) {
                flag = 1;
            }
            pq.offer(new Info(front, back, flag));
        }

        while (!pq.isEmpty()) {
            Info ans = pq.poll();
            System.out.println(ans.front + "." + ans.back);
        }

    }

    static class Info implements Comparable<Info> {

        String front, back;
        int inSet;

        public Info(String front, String back, int inSet) {
            this.front = front;
            this.back = back;
            this.inSet = inSet;
        }

        @Override
        public int compareTo(Info o) {
            if (this.front.equals(o.front)) {
                if (this.inSet == o.inSet) {
                    return this.back.compareTo(o.back);
                }
                return Integer.compare(o.inSet, this.inSet);
            }
            return this.front.compareTo(o.front);
        }
    }
}