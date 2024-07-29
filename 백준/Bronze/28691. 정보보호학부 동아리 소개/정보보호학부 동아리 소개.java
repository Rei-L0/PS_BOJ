import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        if (c == 'M') {
            System.out.println("MatKor");
        } else if (c == 'W') {
            System.out.println("WiCys");
        } else if (c == 'C') {
            System.out.println("CyKor");
        } else if (c == 'A') {
            System.out.println("AlKor");
        } else {
            System.out.println("$clear");
        }
    }
}