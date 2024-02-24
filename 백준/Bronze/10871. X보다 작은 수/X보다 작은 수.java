import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, x;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < x) {
                list.add(num);
            }
        }

        for (int i : list) {
            System.out.print(i + " ");
        }

    }
}