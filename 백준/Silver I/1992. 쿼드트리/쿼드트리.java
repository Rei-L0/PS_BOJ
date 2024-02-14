import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int[][] arr;
    static String ans = "";

    static void check(int x, int y, int n) {
        int check = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != check) {
                    ans += '(';
                    check(x, y, n / 2);
                    check(x, y + n / 2, n / 2);
                    check(x + n / 2, y, n / 2);
                    check(x + n / 2, y + n / 2, n / 2);
                    ans += ')';
                    return;
                }
            }
        }
        ans += check;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());

        arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        check(0, 0, num);

        System.out.println(ans);
    }
}