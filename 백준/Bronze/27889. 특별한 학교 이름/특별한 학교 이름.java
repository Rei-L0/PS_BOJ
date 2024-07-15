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

        if (s.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if (s.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if (s.equals("KIS")) {
            System.out.println("Korea International School");
        } else {
            System.out.println("St. Johnsbury Academy");
        }

    }

}