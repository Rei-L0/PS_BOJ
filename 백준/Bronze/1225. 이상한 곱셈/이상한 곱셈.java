import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        long ans = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                ans += (long) (a.charAt(i) - '0') * (b.charAt(j) - '0');
            }
        }

        System.out.println(ans);
    }

}