import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 23289
public class Main {

    static int r, c, k, w;

    static final int R = 1, L = 2, U = 3, D = 4;

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static int[][] map;

    static ArrayList<Pos> check = new ArrayList<>();
    static ArrayList<Hit> hit = new ArrayList<>();

    static Map<Pos, boolean[]> wall = new HashMap<>();

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Hit {

        int x;
        int y;
        int d;

        public Hit(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

    }

    static class Room implements Comparable<Room> {

        int x;
        int y;
        int n;

        public Room(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public int compareTo(Room o) {
            return Integer.compare(o.n, this.n);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 5) {
                    check.add(new Pos(i, j));
                }
                if (1 <= map[i][j] && map[i][j] <= 4) {
                    hit.add(new Hit(i, j, map[i][j]));
                }
                map[i][j] = 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Pos pos = new Pos(x - 1, y - 1);
            boolean[] list;
            if (wall.containsKey(pos)) {
                list = wall.get(pos);
            } else {
                list = new boolean[5];
            }
            if (d == 1) {
                list[R] = true;
                wall.put(pos, list);

                pos = new Pos(x - 1, y);
                if (wall.containsKey(pos)) {
                    list = wall.get(pos);
                } else {
                    list = new boolean[5];
                }
                list[L] = true;
                wall.put(pos, list);
            } else {
                list[U] = true;
                wall.put(pos, list);

                pos = new Pos(x - 2, y - 1);
                if (wall.containsKey(pos)) {
                    list = wall.get(pos);
                } else {
                    list = new boolean[5];
                }
                list[D] = true;
                wall.put(pos, list);
            }
        }

        int time = 0;
        while (time != 101) {
            for (Hit h : hit) {
                boolean[][] visit = new boolean[r][c];
                wind(h.x + dx[h.d], h.y + dy[h.d], h.d, 5, visit);
            }

            temp();

            minus();

            time++;
            if (check()) {
                break;
            }
        }

        System.out.println(time);

    }

    // 재귀로 바람 퍼뜨리기
    static void wind(int x, int y, int d, int w, boolean[][] visit) {
        if (x < 0 || y < 0 || x >= r || y >= c || w == 0 || visit[x][y]) {
            return;
        }
        visit[x][y] = true;
        map[x][y] += w;

        Pos now = new Pos(x, y);
        Pos next;

        if (d < 3) {
            next = new Pos(x - 1, y);
            if (avail(now, U) && avail(next, d)) {
                wind(x + dx[d] - 1, y + dy[d], d, w - 1, visit);
            }
        } else {
            next = new Pos(x, y - 1);
            if (avail(now, L) && avail(next, d)) {
                wind(x + dx[d], y + dy[d] - 1, d, w - 1, visit);
            }
        }

        if (avail(now, d)) {
            wind(x + dx[d], y + dy[d], d, w - 1, visit);
        }

        if (d < 3) {
            next = new Pos(x + 1, y);
            if (avail(now, D) && avail(next, d)) {
                wind(x + dx[d] + 1, y + dy[d], d, w - 1, visit);
            }
        } else {
            next = new Pos(x, y + 1);
            if (avail(now, R) && avail(next, d)) {
                wind(x + dx[d], y + dy[d] + 1, d, w - 1, visit);
            }
        }
    }

    static boolean avail(Pos now, int d) {
        if (!wall.containsKey(now)) {
            return true;
        }
        boolean[] l = wall.get(now);
        return !l[d];
    }

    // 온도 조절
    static void temp() {
        int[][] add = new int[r][c];
        int[][] minu = new int[r][c];
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                pq.add(new Room(i, j, map[i][j]));
            }
        }

        while (!pq.isEmpty()) {
            Room room = pq.poll();
            spread(new Pos(room.x, room.y), room.x, room.y, room.n, add, minu, 0);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] -= minu[i][j];
                map[i][j] += add[i][j];
            }
        }
    }

    private static void spread(Pos now, int i, int j, int v, int[][] add, int[][] minu, int cnt) {
        if (!wall.containsKey(now)) {
            for (int k = 1; k < 5; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (v > map[nx][ny]) {
                    add[nx][ny] += (v - map[nx][ny]) / 4;
                    cnt += (v - map[nx][ny]) / 4;
                }
            }
        } else {
            boolean[] l = wall.get(now);
            for (int k = 1; k < 5; k++) {
                if (l[k]) {
                    continue;
                }
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (v > map[nx][ny]) {
                    add[nx][ny] += (v - map[nx][ny]) / 4;
                    cnt += (v - map[nx][ny]) / 4;
                }
            }
        }
        minu[i][j] = cnt;
    }

    static void minus() {
        for (int i = 0; i < c; i++) {
            if (map[0][i] > 0) {
                map[0][i]--;
            }
            if (map[r - 1][i] > 0) {
                map[r - 1][i]--;
            }
        }

        for (int i = 1; i < r - 1; i++) {
            if (map[i][0] > 0) {
                map[i][0]--;
            }
            if (map[i][c - 1] > 0) {
                map[i][c - 1]--;
            }
        }
    }

    static boolean check() {
        for (Pos now : check) {
            if (map[now.x][now.y] < k) {
                return false;
            }
        }
        return true;
    }

}