import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (name.equals("#")) {
                break;
            }
            if (age > 17 || w >= 80) {
                System.out.println(name + " Senior");
            } else {
                System.out.println(name + " Junior");
            }
        }

    }
}
