import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Solution {

    static final int RIGHT = 0, LEFT = 1, UP = 3, DOWN = 2;
    static int t, n, m, r, c, l, ans;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] board;

    static void solve() {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        int[][] d = new int[n][m];
        q.add(new Pos(r, c));
        d[r][c] = 1;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            int cur = board[now.x][now.y];
            if (d[now.x][now.y] == l) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || d[nx][ny] != 0) {
                    continue;
                }
                int next = board[nx][ny];
                if (next == 0) {
                    continue;
                }
                if (cur == 1) {
                    if (i == UP) {
                        if (next == 4 || next == 7 || next == 3) {
                            continue;
                        }
                    }
                    if (i == LEFT) {
                        if (next == 6 || next == 7 || next == 2) {
                            continue;
                        }
                    }
                    if (i == DOWN) {
                        if (next == 5 || next == 6 || next == 3) {
                            continue;
                        }
                    }
                    if (i == RIGHT) {
                        if (next == 4 || next == 5 || next == 2) {
                            continue;
                        }
                    }
                } else if (cur == 2) {
                    if (i == RIGHT || i == LEFT || next == 3) {
                        continue;
                    }
                    if (i == UP) {
                        if (next == 4 || next == 7) {
                            continue;
                        }
                    }
                    if (i == DOWN) {
                        if (next == 5 || next == 6) {
                            continue;
                        }
                    }
                } else if (cur == 3) {
                    if (i == UP || i == DOWN || next == 2) {
                        continue;
                    }
                    if (i == LEFT) {
                        if (next == 6 || next == 7) {
                            continue;
                        }
                    }
                    if (i == RIGHT) {
                        if (next == 4 || next == 5) {
                            continue;
                        }
                    }
                } else if (cur == 4) {
                    if (i == DOWN || i == LEFT || cur == next) {
                        continue;
                    }
                    if (i == UP) {
                        if (next == 3 || next == 7) {
                            continue;
                        }
                    }
                    if (i == RIGHT) {
                        if (next == 2 || next == 5) {
                            continue;
                        }
                    }
                } else if (cur == 5) {
                    if (i == UP || i == LEFT || cur == next) {
                        continue;
                    }
                    if (i == DOWN) {
                        if (next == 3 || next == 6) {
                            continue;
                        }
                    }
                    if (i == RIGHT) {
                        if (next == 2 || next == 4) {
                            continue;
                        }
                    }
                } else if (cur == 6) {
                    if (i == UP || i == RIGHT || cur == next) {
                        continue;
                    }
                    if (i == DOWN) {
                        if (next == 3 || next == 5) {
                            continue;
                        }
                    }
                    if (i == LEFT) {
                        if (next == 7 || next == 2) {
                            continue;
                        }
                    }
                } else if (cur == 7) {
                    if (i == DOWN || i == RIGHT || cur == next) {
                        continue;
                    }
                    if (i == UP) {
                        if (next == 3 || next == 4) {
                            continue;
                        }
                    }
                    if (i == LEFT) {
                        if (next == 2 || next == 6) {
                            continue;
                        }
                    }
                }
                q.add(new Pos(nx, ny));
                d[nx][ny] = d[now.x][now.y] + 1;
                ans++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            // 초기화
            ans = 1;
            board = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            // 결과 출력
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
