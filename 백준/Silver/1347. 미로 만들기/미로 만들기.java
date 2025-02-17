import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static final int SIZE = 500;

    static int x = SIZE, y = SIZE, d = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int minX = SIZE, maxX = SIZE, minY = SIZE, maxY = SIZE;
        char[][] arr = new char[SIZE * 2 + 1][SIZE * 2 + 1];
        for (int i = 0; i < SIZE * 2 + 1; i++) {
            for (int j = 0; j < SIZE * 2 + 1; j++) {
                arr[i][j] = '#';
            }
        }
        arr[SIZE][SIZE] = '.';
        for (int i = 0; i < s.length(); i++) {
            char oper = s.charAt(i);
            if (oper == 'R') {
                d = (d + 1) % 4;
            } else if (oper == 'L') {
                d = (d + 3) % 4;
            } else {
                x += dx[d];
                y += dy[d];
                arr[x][y] = '.';
                minX = Math.min(x, minX);
                maxX = Math.max(x, maxX);
                minY = Math.min(y, minY);
                maxY = Math.max(y, maxY);
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
