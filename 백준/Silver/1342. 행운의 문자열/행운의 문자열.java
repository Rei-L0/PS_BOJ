import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int ans;
    static String s;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        solve(-1, -1);

        System.out.println(ans);
    }

    static void solve(int n, int before) {
        if (n == s.length() - 1) {
            ans++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (before != i && arr[i] > 0) {
                arr[i]--;
                solve(n + 1, i);
                arr[i]++;
            }
        }
    }

}