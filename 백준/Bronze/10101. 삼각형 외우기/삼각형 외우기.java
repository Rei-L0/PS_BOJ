import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (a == 60 && b == 60 && c == 60) {
            System.out.print("Equilateral");
        } else if (a + b + c == 180 && ((a == b) || (a == c) || (b == c))) {
            System.out.print("Isosceles");
        } else if (a + b + c == 180 && (a != b) && (a != c) && (b != c)) {
            System.out.print("Scalene");
        } else {
            System.out.print("Error");
        }

    }

}