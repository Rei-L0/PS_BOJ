import java.util.*;



class Solution {

    

    static int M, answer = 0;

    

    public int solution(int n, int[][] q, int[] ans) {

        M = q.length;

        makeCombination(1, 0, n, new int[5], q, ans);

        return answer;

    }

    

    public void makeCombination(int now, int idx, int N, int[] res, int[][] q, int[] ans){

        if(idx == 5){

            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < 5; i++){

                set.add(res[i]);

            }

            check(set, q, ans);

            return;

        }        

        for(int i = now; i <= N; i++){

            res[idx] = i;

            makeCombination(i + 1, idx + 1, N, res, q, ans);

        }

    }

    

    public void check(Set<Integer> set, int[][] q, int[] ans){

        for(int i = 0; i < M; i++){

            int count = 0;

            for(int j = 0; j < 5; j++){

                if(set.contains(q[i][j])){

                    count++;

                }

            }

            if(count != ans[i]){

                return;

            }

        }

        answer++;

        return;

    }

    

}