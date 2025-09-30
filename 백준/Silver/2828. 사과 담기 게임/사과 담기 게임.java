import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 스크린 크기 (사용되진 않음)
        int M = Integer.parseInt(st.nextToken()); // 바구니 크기

        int J = Integer.parseInt(br.readLine()); // 사과 개수

        int left = 1;
        int right = M;

        int totalMove = 0; // 총 이동 거리

        for (int i = 0; i < J; i++) {
            int applePos = Integer.parseInt(br.readLine());

            if (applePos < left) {
                int move = left - applePos;
                totalMove += move;
                left -= move;
                right -= move;

            } else if (applePos > right) {
                int move = applePos - right;
                totalMove += move;
                left += move;
                right += move;
            }
        }

        System.out.print(totalMove);
    }
}