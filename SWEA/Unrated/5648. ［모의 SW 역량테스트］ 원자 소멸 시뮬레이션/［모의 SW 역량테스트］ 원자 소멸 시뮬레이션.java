import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, ans;

	static final int MAX = 2000;

	static LinkedHashMap<Integer, Atom> map = new LinkedHashMap<>();

	// 상, 하, 좌, 우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Atom {
		int x;
		int y;
		int d;
		int k;

		@Override
		public String toString() {
			return "Atom [x=" + x + ", y=" + y + ", d=" + d + ", k=" + k + "]";
		}

		public Atom(int x, int y, int d, int k) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
	}

	static class Pos {
		int x;
		int y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());

		ans = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bReader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map.put(i, new Atom(y * 2, x * 2, d, k));
		}
	}

	// 원자들 이동 시키기
	// x, y가 -2000보다 작거나 2000보다 클 때 map에서 삭제
	// check map으로 같은 좌표에 있는 원자들 제거
	static void solve() {

		ArrayDeque<Integer> removeList = new ArrayDeque<>();
		HashMap<Pos, Pos> removePos = new HashMap<>();
		while (map.size() > 1) {
			// 좌표 저장할 HashMap
			LinkedHashMap<Pos, ArrayList<Integer>> check = new LinkedHashMap<>();
			// 원자들 이동
			for (Integer k : map.keySet()) {
				Atom v = map.get(k);
				int nx = v.x + dx[v.d];
				int ny = v.y + dy[v.d];
				if (MAX < nx || nx < -MAX || MAX < ny || ny < -MAX) {
					removeList.add(k);
					continue;
				}

				// map에 이동한 원자 정보 update
				map.put(k, new Atom(nx, ny, v.d, v.k));

				// 이동한 좌표에 list 생성 후 원자들의 key 값 저장
				Pos now = new Pos(nx, ny);
				ArrayList<Integer> list;
				// 중복인 좌표들을 리스트에 저장
				if (check.containsKey(now)) {
					list = check.get(now);
					removePos.put(now, now);
				} else
					list = new ArrayList<>();
				list.add(k);
				check.put(now, list);
			}

			while (!removeList.isEmpty())
				map.remove(removeList.poll());

			for (Pos key : removePos.keySet()) {
				ArrayList<Integer> list = check.get(key);
				// 2개 이상일 경우 결과값에 더하고 해당 원자 map에서 삭제
				for (int x : list) {
					ans += map.get(x).k;
					map.remove(x);
				}
			}
			// 제거 좌표 맵 제거
			removePos.clear();
		}
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			init();
			solve();
			System.out.println("#" + tc + " " + ans);
		}

	}
}