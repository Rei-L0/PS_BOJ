import java.io.*;
import java.util.*;

public class Main {


    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("LoveisKoreaUniversity").append(" ");
        }

        System.out.println(sb);
    }
}
