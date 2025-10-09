import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        String input;
        while ((input = br.readLine()) != null) {
            
            if (input.trim().isEmpty()) {
                continue;
            }
            
            int N = Integer.parseInt(input.trim());
            
            if (N == 0) {
                sb.append(0).append("\n");
                if (br.ready()) { 
                    br.readLine();
                }
                continue;
            }

            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            ArrayList<Integer> lis = new ArrayList<>();
            lis.add(arr[0]); 
            
            for (int i = 1; i < N; i++) {
                int currentVal = arr[i];
                
                if (currentVal > lis.get(lis.size() - 1)) {
                    lis.add(currentVal);
                } else {
                    int index = Collections.binarySearch(lis, currentVal);
                    
                    if (index < 0) {
                        index = -(index + 1);
                    }
                    
                    lis.set(index, currentVal);
                }
            }
            
            sb.append(lis.size()).append("\n");
        }

        System.out.print(sb);
    }
}