import java.util.*;
import java.io.*;

public class Main {
    
    static Map<Integer, String> map;
    static Map<String, Integer> count;
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        String[] arr = new String[] {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
        
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        } 
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            count = new HashMap<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                if(!count.containsKey(mbti)) count.put(mbti, 1);
                else count.put(mbti, count.get(mbti) + 1);
            }
            
            int ans = 100;
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr.length; k++) {
                        int res = 0;
                        if(isAvail(i, j, k)) {
                            res += getDis(i, j);
                            res += getDis(k, j);
                            res += getDis(i, k);
                            ans = Math.min(ans, res);
                        }
                    } 
                } 
            } 
            
            System.out.println(ans);
        }
	}
	
	static boolean isAvail (int i, int j, int k) {
	    String im = map.get(i);
	    String jm = map.get(j);
	    String km = map.get(k);
	    if(!count.containsKey(im) || !count.containsKey(jm) || !count.containsKey(km)) return false;
	    
	    count.put(im, count.get(im) - 1);
	    count.put(jm, count.get(jm) - 1);
	    count.put(km, count.get(km) - 1);
	    
	    if (count.get(im) >= 0 && count.get(jm) >= 0 && count.get(km) >= 0){
	        count.put(im, count.get(im) + 1);
	        count.put(jm, count.get(jm) + 1);
	        count.put(km, count.get(km) + 1);
	        return true;
	    }else{
	        count.put(im, count.get(im) + 1);
	        count.put(jm, count.get(jm) + 1);
	        count.put(km, count.get(km) + 1);
	        return false;
	    }
	}
	
	static int getDis (int x, int y) {
	    String s1 = map.get(x);
	    String s2 = map.get(y);
	    int cnt = 0;
	    for (int i = 0; i < 4; i++) {
	        if(s1.charAt(i) != s2.charAt(i)) cnt++;
	    }
	    return cnt;
	}
	
	
}