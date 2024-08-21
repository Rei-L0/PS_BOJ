import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String ans = "";
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int people = Integer.parseInt(st.nextToken());
            if (cnt < people) {
                ans = s;
                cnt = people;
            }
        }

        System.out.println(ans);
    }

}