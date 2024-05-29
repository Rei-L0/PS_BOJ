import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char[][] ansMap; 
    static int[][] map; 
    static boolean[][] isExplod; 
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        ansMap = new char[R][C];
        isExplod = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == '.') {
                    map[i][j] = 0;
                } else if (c == 'O') {
                    map[i][j] = 3;
                }
            }
        }

        for (int t = 2; t <= N; t++) {
            isExplod = new boolean[R][C];
            setBomb(t);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == t) {
                        checkExplod(i, j);
                    }
                }
            }
            explosion();
        }

        printAnswer();
    }

    static void explosion() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isExplod[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    static void setBomb(int startTime) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = startTime + 3;
                }
            }
        }
    }

    static void checkExplod(int x, int y) {
        isExplod[x][y] = true;

        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            isExplod[nx][ny] = true;
        }
    }

    static void printAnswer() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    ansMap[i][j] = '.';
                } else {
                    ansMap[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(ansMap[i][j]);
            }
            System.out.println();
        }
    }

}