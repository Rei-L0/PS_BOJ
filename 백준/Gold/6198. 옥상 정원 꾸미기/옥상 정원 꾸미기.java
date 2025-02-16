import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long ANS = 0;
    static int[] h;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= h[i]) {
                stack.pop();
            }
            ANS += stack.size(); // 현재 빌딩에서 볼 수 있는 빌딩 개수 추가
            stack.push(h[i]); // 현재 빌딩을 스택에 추가
        }

        System.out.println(ANS);
    }
}
