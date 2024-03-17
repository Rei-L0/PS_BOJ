import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n];
        arr[0] = num[0];

        int l = 0;
        int r = 1;

        while (r < n) {
            if (arr[l] < num[r]) {
                arr[l + 1] = num[r];
                l++;
            } else {
                int idx = bs(0, l, num[r]);
                arr[idx] = num[r];
            }
            r++;
        }

        System.out.println(l + 1);

    }

    static int bs(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}