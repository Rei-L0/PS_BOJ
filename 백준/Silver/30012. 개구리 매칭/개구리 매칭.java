import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int minHp = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int dis = Math.abs(arr[i] - s);
            int hp = 0;
            hp = Math.max(k * 2 - dis, 0);
            dis -= k * 2;
            if (dis > 0) {
                hp += dis * l;
            }
            if (hp < minHp) {
                minHp = hp;
                num = i + 1;
            }
        }

        System.out.println(minHp + " " + num);
    }
}