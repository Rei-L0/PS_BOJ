class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1; // 다음에 전파를 전달해야 할 아파트의 위치
        int stationIndex = 0; // 현재 확인할 기지국의 인덱스
        int coverage = 2 * w + 1; // 기지국 하나가 커버하는 범위

        while (position <= n) {
            // 현재 확인할 기지국이 남아있고, 그 기지국이 현재 위치(position)를 커버하는 경우
            if (stationIndex < stations.length && stations[stationIndex] - w <= position) {
                // position을 해당 기지국의 커버 범위 바로 다음으로 이동
                position = stations[stationIndex] + w + 1;
                stationIndex++; // 다음 기지국을 확인하기 위해 인덱스 증가
            } 
            // 기지국이 없거나, 현재 기지국이 position을 커버하지 못하는 경우
            else {
                // 새로운 기지국을 설치해야 함
                answer++;
                // 새로운 기지국을 설치했으므로, 커버 범위만큼 position 이동
                position += coverage;
            }
        }

        return answer;
    }
}