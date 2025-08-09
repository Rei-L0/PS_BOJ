import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 1. 차량을 진출 지점(routes[i][1]) 기준으로 오름차순 정렬합니다.
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int answer = 0;
        
        // 카메라의 위치를 나타내는 변수, 초기값은 가장 작은 값으로 설정
        int cameraPos = Integer.MIN_VALUE;

        // 2. 정렬된 경로를 순회합니다.
        for (int[] route : routes) {
            // 3. 현재 차량의 진입 지점이 마지막 카메라 위치보다 뒤에 있다면
            if (cameraPos < route[0]) {
                // 새로운 카메라를 설치해야 합니다.
                answer++;
                // 카메라 위치를 현재 차량의 진출 지점으로 업데이트합니다.
                cameraPos = route[1];
            }
        }
        
        return answer;
    }
}