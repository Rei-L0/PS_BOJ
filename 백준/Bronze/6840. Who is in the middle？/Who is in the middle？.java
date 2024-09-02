import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);

        System.out.println(list.get(list.size() / 2));
    }
}