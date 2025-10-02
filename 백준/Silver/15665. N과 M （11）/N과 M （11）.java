import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    
    static List<Integer> list;
    
    static StringBuilder sb;
    static BufferedReader br;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        boolean[] check = new boolean[10001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!check[num]) {
                list.add(num);
                check[num] = true;
            }
        }
        
        sb = new StringBuilder();
        
        Collections.sort(list);
        makePermutation(new int[M], 0);
        
        System.out.print(sb);
	}
	
	static void makePermutation (int[] visit, int cnt) {
	    if (cnt == M) {
	        for (int i = 0; i < M; i++) {
	            sb.append(visit[i]).append(" ");
	        } 
	        sb.append("\n");
	        return;
	    }
	    for (int i = 0; i < list.size(); i++) {
	        visit[cnt] = list.get(i);
	        makePermutation(visit, cnt + 1);
	    } 
	}
	
}