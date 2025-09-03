class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = Long.MAX_VALUE;
        
        while (left < right){
            long mid = (left + right) / 2;
            if(check(n, mid, times)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean check(int n, long mid, int[] times){
        long processedCount = 0; 
        
        for (int time : times) {
            processedCount += mid / time;

            if (processedCount >= n) {
                return true;
            }
        }
    
        return processedCount >= n;
    }
    
}