import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        System.out.println(solve(set));
    }

    static String solve(Set<Character> set) {
        String mobis = "MOBIS";
        for (int i = 0; i < mobis.length(); i++) {
            if (!set.contains(mobis.charAt(i))) {
                return "NO";
            }
        }
        return "YES";
    }

}