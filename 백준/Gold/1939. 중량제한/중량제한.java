import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Edge>[] islands;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        islands = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            islands[i] = new ArrayList<>();
        }

        int maxWeight = 0;  // 다리의 최대 중량을 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            islands[from].add(new Edge(to, weight));
            islands[to].add(new Edge(from, weight));
            
            maxWeight = Math.max(maxWeight, weight);  // 최대 중량 갱신
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 이분 탐색 범위 설정
        int left = 1;
        int right = maxWeight;
        int result = 0;

        // 이분 탐색으로 가능한 최대 중량 찾기
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(start, end, mid)) {
                result = mid;  // 가능한 중량이면 결과 갱신
                left = mid + 1;  // 더 큰 중량 탐색
            } else {
                right = mid - 1;  // 더 작은 중량 탐색
            }
        }

        System.out.println(result);
    }

    // BFS를 사용하여 중량 제한이 mid일 때 두 섬이 연결될 수 있는지 확인
    static boolean canCross(int start, int end, int limit) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return true;  // 목적지에 도달
            }

            for (Edge edge : islands[current]) {
                if (!visited[edge.to] && edge.weight >= limit) {  // 중량 제한을 넘는 다리만 사용
                    visited[edge.to] = true;
                    queue.add(edge.to);
                }
            }
        }

        return false;  // 도달하지 못하면 false
    }
}