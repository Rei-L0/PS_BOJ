import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int t, n, minVal, maxVal;
    static int[] oper, num;

    static void solve(int[] op, int count) {
        if (count == (n - 1)) {
            int result = getResult(op);
            maxVal = Math.max(result, maxVal);
            minVal = Math.min(result, minVal);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) {
                continue;
            }
            op[count] = i;
            oper[i]--;
            solve(op, count + 1);
            oper[i]++;
        }
    }

    private static int getResult(int[] op) {
        int result = num[0];
        for (int i = 0; i < n - 1; i++) {
            switch (op[i]) {
                case 0:
                    result += num[i + 1];
                    break;
                case 1:
                    result -= num[i + 1];
                    break;
                case 2:
                    result *= num[i + 1];
                    break;
                case 3:
                    result /= num[i + 1];
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;

            oper = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                oper[i] = Integer.parseInt(st.nextToken());
            }

            num = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            solve(new int[n - 1], 0);

            System.out.println("#" + tc + " " + Math.abs(maxVal - minVal));
        }
    }
}