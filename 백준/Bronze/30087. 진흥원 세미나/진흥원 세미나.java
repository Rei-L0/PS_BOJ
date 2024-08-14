import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

            String s = br.readLine();

            if (s.equals("Algorithm")) {
                System.out.println(204);
            } else if (s.equals("DataAnalysis")) {
                System.out.println(207);
            } else if (s.equals("ArtificialIntelligence")) {
                System.out.println(302);
            } else if (s.equals("CyberSecurity")) {
                System.out.println("B101");
            } else if (s.equals("Network")) {
                System.out.println(303);
            } else if (s.equals("Startup")) {
                System.out.println(501);
            } else {
                System.out.println(105);
            }
        }
    }

}