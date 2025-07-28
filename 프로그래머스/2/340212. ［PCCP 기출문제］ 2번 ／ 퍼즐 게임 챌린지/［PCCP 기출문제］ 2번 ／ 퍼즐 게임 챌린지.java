class Solution {
    
    static int N, answer = 0;
    
    public int solution(int[] diffs, int[] times, long limit) {
        N = diffs.length;
        int lo = 0;
        int hi = 10_0001;
        
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(check(diffs, times, limit, mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        answer = lo;
        return answer;
    }
    
    public boolean check(int[] diffs, int[] times, long limit, int level) {
    long spend_time = 0;
    
    // i = 0 일 때를 먼저 처리
    if (diffs[0] <= level) {
        spend_time += times[0];
    } else {
        // i=0일 때의 페널티는 times[-1]이 없으므로 문제의 조건에 맞게 별도 정의 필요
        // 만약 첫 단계부터 초과하면 무조건 실패라면, 아래와 같이 처리 가능
        return false; 
    }
    
    // i = 1 부터 루프를 시작하여 i-1 접근을 안전하게 만듦
    for (int i = 1; i < N; i++) {
        if (diffs[i] <= level) {
            spend_time += times[i];
        } else {
            // 이제 i-1은 항상 0 이상이므로 안전함
            spend_time += (long)(times[i - 1] + times[i]) * (diffs[i] - level) + times[i];
        }
        
        if (spend_time > limit) {
            return false;
        }
    }
    return true;
}
}