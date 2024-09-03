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

        String[] arr = new String[n + 1];
        arr[1] = "CY";
        for (int i = 1; i <= n; i++) {
            if (arr[i].equals("CY")) {
                if (i + 1 <= n && arr[i + 1] == null) {
                    arr[i + 1] = "SK";
                }
                if (i + 3 <= n && arr[i + 3] == null) {
                    arr[i + 3] = "SK";
                }
            } else {
                if (i + 1 <= n && arr[i + 1] == null) {
                    arr[i + 1] = "CY";
                }
                if (i + 3 <= n && arr[i + 3] == null) {
                    arr[i + 3] = "CY";
                }
            }
        }

        System.out.println(arr[n]);
    }
}