import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long speed = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > speed) {
                speed = arr[i];
            } else {
                if (speed % arr[i] != 0) {
                    speed = (speed / arr[i] + 1) * arr[i];
                }
            }
        }

        System.out.println(speed);
    }


}