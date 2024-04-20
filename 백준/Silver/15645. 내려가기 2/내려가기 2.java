import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, maxVal, minVal = Integer.MAX_VALUE;

    static int[][] num, max, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        num = new int[n][3];
        max = new int[n][3];
        min = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    max[i][j] = num[i][j];
                    min[i][j] = num[i][j];
                }
            }
        }

        getMax();
        getMin();

        for (int i = 0; i < 3; i++) {
            minVal = Math.min(minVal, min[n - 1][i]);
            maxVal = Math.max(maxVal, max[n - 1][i]);
        }

        System.out.println(maxVal + " " + minVal);

    }

    static void getMax() {
        for (int i = 1; i < n; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + num[i][0];
            max[i][1] = Math.max(max[i - 1][2], Math.max(max[i - 1][0], max[i - 1][1])) + num[i][1];
            max[i][2] = Math.max(max[i - 1][2], max[i - 1][1]) + num[i][2];
        }
    }

    static void getMin() {
        for (int i = 1; i < n; i++) {
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + num[i][0];
            min[i][1] = Math.min(min[i - 1][2], Math.min(min[i - 1][0], min[i - 1][1])) + num[i][1];
            min[i][2] = Math.min(min[i - 1][2], min[i - 1][1]) + num[i][2];
        }
    }

}