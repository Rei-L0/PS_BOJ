import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int use = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean check = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != use) {
                        int cnt = 0;
                        for (int x = 0; x < n; x++) {
                            if (arr[x][j] == use) {
                                cnt++;
                            }
                        }
                        if (cnt > n / 2) {
                            check = true;
                            arr[i][j] = use;
                            break;
                        } else {
                            cnt = 0;
                            for (int x = 0; x < n; x++) {
                                if (arr[i][x] == use) {
                                    cnt++;
                                }
                            }
                            if (cnt > n / 2) {
                                check = true;
                                arr[i][j] = use;
                                break;
                            }
                        }
                    }
                }
                if (check) {
                    break;
                }
            }
            if (!check) {
                break;
            }
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != use) {
                    ans = 0;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

}