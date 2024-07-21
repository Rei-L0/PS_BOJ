import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
            if (i < s1.length()) {
                list.add(arr[s1.charAt(i) - 'A']);
            }
            if (i < s2.length()) {
                list.add(arr[s2.charAt(i) - 'A']);
            }
        }

        List<Integer> next = new ArrayList<>();
        while (next.size() != 2) {
            next = solve(list);
            list = next;
        }

        sb.append(next.get(0)).append(next.get(1)).append("\n");
        System.out.println(sb);
    }


    static List<Integer> solve(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            res.add((list.get(i) + list.get(i + 1)) % 10);
        }
        return res;
    }


}