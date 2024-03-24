
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int ans=0;
        
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            ans+=n;
        }

        System.out.println(ans);

    }

}