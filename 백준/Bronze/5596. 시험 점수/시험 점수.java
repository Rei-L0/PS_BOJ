import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[2];

        for (int j = 0; j < 2; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                num[j] += Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Math.max(num[0], num[1]));

    }

}