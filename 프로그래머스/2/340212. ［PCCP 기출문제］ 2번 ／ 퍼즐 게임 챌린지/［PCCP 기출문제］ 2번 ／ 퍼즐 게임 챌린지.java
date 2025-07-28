class Solution {

    static int N, answer = 0;

    public int solution(int[] diffs, int[] times, long limit) {
        N = diffs.length;
        int lo = 1;
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

    public boolean check(int[] diffs, int[] times, long limit, int level){
        long spend_time = 0;
        for(int i = 0; i < N; i++){
            if(diffs[i] <= level){
                spend_time += times[i];
            }else{
                spend_time += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
            if(spend_time > limit){
                return false;
            }
        }
        return true;
    }
}