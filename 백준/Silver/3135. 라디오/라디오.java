import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ans = (a > b) ? a - b : b - a;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            ans = Math.min(ans, (h > b) ? h - b + 1 : b - h + 1);
        }

        System.out.println(ans);
    }
}
