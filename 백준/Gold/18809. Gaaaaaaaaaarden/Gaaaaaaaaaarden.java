import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {

	int x;
	int y;
	int color;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = 0;
	}

	public Pos(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", color=" + color;
	}
}

class Check {

	int time;
	int color;

	public Check() {
		this.time = -1;
		this.color = 0;
	}

	@Override
	public String toString() {
		return "time=" + time + ", color=" + color + "";
	}

}

// 18809
public class Main {

	static int n, m, g, r, ans = 0, nx, ny;
	static int[][] ground;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Pos> availGround = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		g = Integer.parseInt(stringTokenizer.nextToken());
		r = Integer.parseInt(stringTokenizer.nextToken());

		ground = new int[n][m];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if (ground[i][j] == 2) {
					availGround.add(new Pos(i, j));
				}
			}
		}

		choiceGround(new boolean[availGround.size()], 0, 0);
		System.out.println(ans);
		return;
	}

	// 배양액을 뿌릴 땅의 위치를 정하는 메서드
	static void choiceGround(boolean[] visit, int start, int count) {
		if (count == (g + r)) {
			Pos[] pos = new Pos[g + r];
			int idx = 0;
			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					pos[idx++] = availGround.get(i);
				}
			}
			choiceColor(pos, new boolean[pos.length], 0, 0);
		}
		for (int i = start; i < availGround.size(); i++) {
			visit[i] = true;
			choiceGround(visit, i + 1, count + 1);
			visit[i] = false;
		}
	}

	// 뿌릴 땅에 어떤 색의 배양액을 뿌릴지 정하는 메서드
	static void choiceColor(Pos[] pos, boolean[] visit, int start, int count) {
		if (count == g) {
			ArrayDeque<Pos> queue = new ArrayDeque<>();
			for (int i = 0; i < pos.length; i++) {
				if (visit[i]) {
					pos[i].color = 3;
				} else {
					pos[i].color = 4;
				}
				queue.add(pos[i]);
			}
			bfs(queue);
		}
		for (int i = start; i < pos.length; i++) {
			visit[i] = true;
			choiceColor(pos, visit, i + 1, count + 1);
			visit[i] = false;
		}
	}

	static void bfs(ArrayDeque<Pos> queue) {
		Check[][] spread = new Check[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				spread[i][j] = new Check();
			}
		}
		Pos cur;
		int flower = 0;
		for (int i = 0; i < queue.size(); i++) {
			cur = queue.poll();
			spread[cur.x][cur.y].color = cur.color;
			spread[cur.x][cur.y].time = 0;
			queue.add(cur);
		}
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (spread[cur.x][cur.y].color == -1)
				continue;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				// 범위 밖으로 나갈 때
				if (nx == n || nx == -1 || ny == m || ny == -1)
					continue;
				// 호수거나 다음 칸이 꽃일 때
				if (ground[nx][ny] == 0 || spread[nx][ny].color == -1)
					continue;

				if (spread[nx][ny].time == spread[cur.x][cur.y].time + 1
						&& spread[nx][ny].color != spread[cur.x][cur.y].color) {
					spread[nx][ny].color = -1;
					flower += 1;
					continue;
				}
				if (spread[nx][ny].time != -1)
					continue;
				spread[nx][ny].time = spread[cur.x][cur.y].time + 1;
				spread[nx][ny].color = spread[cur.x][cur.y].color;
				queue.add(new Pos(nx, ny, spread[nx][ny].color));
			}
		}
		ans = Math.max(ans, flower);
	}
}