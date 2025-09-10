import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static Circle[] circles;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            circles = new Circle[N];
            visited = new boolean[N];
            adj = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                circles[i] = new Circle(x, y, r);
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (areConnected(circles[i], circles[j])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }

            int groupCount = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    bfs(i);
                    groupCount++;
                }
            }
            sb.append(groupCount).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    static boolean areConnected(Circle c1, Circle c2) {
        long dx = c1.x - c2.x;
        long dy = c1.y - c2.y;
        long radiiSum = c1.r + c2.r;

        return dx * dx + dy * dy <= radiiSum * radiiSum;
    }

    static class Circle {
        int x, y, r;

        Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}