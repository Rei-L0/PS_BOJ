import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder ans = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            ans.append(s.charAt(i));
        }

        System.out.println(ans);
    }

}