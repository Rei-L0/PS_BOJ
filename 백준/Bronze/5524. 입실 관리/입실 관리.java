import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringBuilder sx = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sx.append(Character.toLowerCase(s.charAt(j)));
            }
            sb.append(sx).append("\n");
        }
        System.out.println(sb);
    }

}