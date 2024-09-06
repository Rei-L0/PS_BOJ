import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] graph=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        for(int i=0;i<roads.length;i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(destination);
        dis[destination]=0;
        
        while(!q.isEmpty()){
            int now=q.poll();
            for(int next:graph[now]){
                if(dis[next]>dis[now]+1){
                    dis[next]=dis[now]+1;
                    q.offer(next);
                }
            }
        }
        
        for(int i=0;i<sources.length;i++){
            answer[i]=dis[sources[i]]==Integer.MAX_VALUE?-1:dis[sources[i]];
        }
        
        return answer;
    }
}