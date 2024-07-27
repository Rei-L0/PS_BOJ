import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char s = br.readLine().charAt(0);

        if (s == 'N' || s == 'n') {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }

    }
}