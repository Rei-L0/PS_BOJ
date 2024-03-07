import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static final char WALL = '*';

	static int r, c, t, ans;

	static HashSet<Character> key;
	static ArrayList<Pos> start;
	static ArrayDeque<Pos> q = new ArrayDeque<>();

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static char[][] map;
	static boolean[][] visit;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void init() {
		for (int i = 0; i < start.size(); i++) {
			Pos s = start.get(i);
			q.add(new Pos(s.x, s.y));
			visit[s.x][s.y] = true;
		}
	}

	static boolean check(int x, int y) {
		if (map[x][y] == '$') {
			ans++;
			map[x][y] = '.';
		}
		if ('a' <= map[x][y] && map[x][y] <= 'z') {
			if (!key.contains(map[x][y])) {
				key.add(map[x][y]);
				q.clear();
				visit = new boolean[r][c];
				init();
			}
		}
		if ('A' <= map[x][y] && map[x][y] <= 'Z') {
			if (!key.contains(Character.toLowerCase(map[x][y]))) {
				return false;
			}
		}
		return true;
	}

	static void solve() {

		while (!q.isEmpty()) {
			Pos now = q.poll();
			if (!check(now.x, now.y))
				continue;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (map[nx][ny] == WALL || visit[nx][ny])
					continue;
				if (!check(nx, ny))
					continue;
				map[nx][ny] = '.';
				visit[nx][ny] = true;
				q.add(new Pos(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			ans = 0;

			visit = new boolean[r][c];
			map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			String keys = br.readLine();
			key = new HashSet<>();
			if (keys.charAt(0) != '0') {
				for (int i = 0; i < keys.length(); i++) {
					key.add(keys.charAt(i));
				}
			}

			start = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i == 0 || j == 0 || i == (r - 1) || j == (c - 1)) {
						if (map[i][j] == '.')
							start.add(new Pos(i, j));
						else if ('a' <= map[i][j] && map[i][j] <= 'z') {
							start.add(new Pos(i, j));
						} else if ('A' <= map[i][j] && map[i][j] <= 'Z') {
							start.add(new Pos(i, j));
						} else if (map[i][j] == '$') {
							start.add(new Pos(i, j));
						}
					}
				}
			}

			init();
			solve();
			System.out.println(ans);
		}
	}
}