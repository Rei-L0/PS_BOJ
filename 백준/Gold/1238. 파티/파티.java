import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n, m, x;
    static final int MAX_VALUE = Integer.MAX_VALUE;
    static HashMap<Integer, ArrayList<Node>> map;

    static class Node implements Comparable<Node> {

        int next;
        int w;

        public Node(int next, int w) {
            this.next = next;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int checkTime(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        // 맥스값 초기화
        int[] time = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            time[i] = MAX_VALUE;
        }

        // q가 빌 때까지 순회
        while (!q.isEmpty()) {
            Node cur = q.poll();
            ArrayList<Node> arr = map.get(cur.next);
            for (Node node : arr) {
                if (cur.w + node.w < time[node.next]) {
                    time[node.next] = cur.w + node.w;
                    q.offer(new Node(node.next, time[node.next]));
                }
            }
        }
        return time[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            ArrayList<Node> arr;
            if (map.containsKey(s)) {
                arr = map.get(s);
            } else {
                arr = new ArrayList<>();
            }
            arr.add(new Node(e, w));
            map.put(s, arr);
        }

        int[] res = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            res[i] = checkTime(i, x) + checkTime(x, i);
            ans = Math.max(res[i], ans);
        }
        System.out.println(ans);
    }
}