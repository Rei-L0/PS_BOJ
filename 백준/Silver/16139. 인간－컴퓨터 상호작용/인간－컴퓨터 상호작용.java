import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[][] arr = makeSet(s);
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(arr[a - 'a'][r + 1] - arr[a - 'a'][l]).append("\n");
        }
        System.out.println(sb);
    }

    static int[][] makeSet(String s) {
        int[][] arr = new int[26][s.length() + 1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (s.charAt(j - 1) - 'a' == i) {
                    arr[i][j]++;
                }
                arr[i][j] += arr[i][j - 1];
            }
        }

        return arr;
    }

}