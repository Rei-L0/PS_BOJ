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

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }

        System.out.println(solve(n, arr));
    }

    static String solve(int n, char[][] arr) {
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(arr[i][j]);
            }
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++) {
                col.append(arr[j][i]);
            }
            if (!row.toString().equals(col.toString())) {
                return "NO";
            }
        }
        return "YES";
    }

}