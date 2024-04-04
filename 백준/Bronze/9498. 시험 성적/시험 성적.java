import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char ans;
        if (n >= 90) {
            ans = 'A';
        } else if (n >= 80) {
            ans = 'B';
        } else if (n >= 70) {
            ans = 'C';
        } else if (n >= 60) {
            ans = 'D';
        } else {
            ans = 'F';
        }
        System.out.println(ans);
    }
}