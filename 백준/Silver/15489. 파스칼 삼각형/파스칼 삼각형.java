import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] pascal = new int[r + w + 1][r + w + 1];

        int ans = 0;
        int l = 0;

        for (int i = 1; i < r + w; i++) {
            if (r <= i && i < r + w) {
                l++;
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
                if (r <= i && i < r + w) {
                    if (c <= j && j < c + l) {
                        ans += pascal[i][j];
                    }
                }
            }
        }

        System.out.println(ans);
    }

}