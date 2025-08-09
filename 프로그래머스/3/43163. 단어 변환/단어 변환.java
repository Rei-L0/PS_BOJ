class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        dfs(0, begin, target, new boolean[words.length], words);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(int count, String cur_s, String target, boolean[] visit, String[] words){
        if(count > answer){
            return;
        }
        
        if(cur_s.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visit[i]){
                continue;
            }
            if(check(words[i], cur_s)){
                visit[i] = true;
                dfs(count + 1, words[i], target, visit, words);
                visit[i] = false;
            }
        }
    }
    
    public boolean check(String x, String y){
        int len = x.length();
        int count = 0;
        for(int i = 0; i < len; i++){
            if(x.charAt(i) == y.charAt(i)){
                count++;
            }
        }
        return (len - 1) == count;
    }
}