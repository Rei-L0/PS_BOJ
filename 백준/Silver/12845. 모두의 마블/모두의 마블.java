import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static class Card implements Comparable<Card> {

        int level;

        public Card(int level) {
            this.level = level;
        }

        public int compareTo(Card o) {
            return Integer.compare(o.level, this.level);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Card> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());

            pq.offer(new Card(level));
        }

        long gold = 0;

        while (pq.size() != 1) {
            Card first = pq.poll();
            Card second = pq.poll();
            gold += first.level + second.level;
            pq.offer(new Card(first.level));
        }

        System.out.println(gold);
    }

}