import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            int scoreA = 0;
            int scoreB = 0;
            for (int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine());

                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);

                scoreA += solve(a, b);
                scoreB += solve(b, a);


            }
            if (scoreA > scoreB) {
                sb.append("Player 1\n");
            } else if (scoreA < scoreB) {
                sb.append("Player 2\n");
            } else {
                sb.append("TIE\n");
            }
        }

        System.out.println(sb);
    }

    static int solve(char a, char b) {
        if (a == 'R') {
            if (b == 'R') {
                return 0;
            } else if (b == 'S') {
                return 1;
            } else {
                return -1;
            }
        } else if (a == 'S') {
            if (b == 'S') {
                return 0;
            } else if (b == 'R') {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (b == 'R') {
                return 1;
            } else if (b == 'S') {
                return -1;
            } else {
                return 0;
            }
        }
    }

}