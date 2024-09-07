import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력받기
        int N = Integer.parseInt(st.nextToken()); // 점의 개수
        int M = Integer.parseInt(st.nextToken());  // 선분의 개수

        // 점의 좌표를 배열로 입력받고 정렬
        st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);

        // 각 선분에 대해 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 이분 탐색으로 시작점 이상인 첫 번째 점의 위치 찾기
            int left = lowerBound(points, start);
            // 이분 탐색으로 끝점 이하인 마지막 점의 위치 찾기
            int right = upperBound(points, end);

            // 선분 안에 포함된 점의 개수는 right - left
            sb.append(right - left).append("\n");
        }

        System.out.println(sb);
    }

    // lowerBound: 시작점 이상인 첫 번째 점의 위치 찾기
    private static int lowerBound(int[] points, int target) {
        int low = 0;
        int high = points.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (points[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // upperBound: 끝점 이하인 마지막 점의 다음 위치 찾기
    private static int upperBound(int[] points, int target) {
        int low = 0;
        int high = points.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (points[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
