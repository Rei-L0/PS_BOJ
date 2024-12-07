import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int sub = Y - X;

        if (sub == 0) {
            System.out.println(0);
            return;
        }

        for (long base = 1, gap = Y - X; ; base++) {
            long sum = base * base + base;
            if (sum < gap) {
                continue;
            }
            System.out.println(base * 2 + (sum - base >= gap ? -1 : 0));
            return;
        }
    }
}
