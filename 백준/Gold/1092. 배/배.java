import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> crain = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crain.add(Integer.parseInt(st.nextToken()));
        }

        crain.sort(Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());

        int time = 0;

        ArrayList<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > crain.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n; ) {
                if (idx == boxes.size()) {
                    break;
                } else if (crain.get(i) >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}