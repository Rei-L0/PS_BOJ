import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 무선 충전  
public class Solution {

	static int t, m, a, ans;
	static int aX, bX, aY, bY;
	static int[] moveA, moveB;

	static int[] dy = { 0, 0, 1, 0, -1 };
	static int[] dx = { 0, -1, 0, 1, 0 };

	static ArrayList<Charger> arrayList;

	static class Charger {
		int num;
		int x;
		int y;
		int c;
		int p;

		public Charger(int num, int x, int y, int c, int p) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	// 초기화
	static void Init() {
		aX = 1;
		aY = 1;
		bX = 10;
		bY = 10;
		ans = 0;
		arrayList = new ArrayList<>();
	}

	// 사용자 움직임
	static void movePerson(int index) {
		aX += dx[moveA[index]];
		aY += dy[moveA[index]];
		bX += dx[moveB[index]];
		bY += dy[moveB[index]];
	}

	static void checkCharge() {
		int sum = 0;
		int res = 0;
		Charger ca = null;
		Charger cb = null;
		ArrayList<Charger> availA = new ArrayList<>();
		ArrayList<Charger> availB = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			Charger cur = arrayList.get(i);
			if (cur.c >= (Math.abs(aX - cur.x) + Math.abs(aY - cur.y)))
				availA.add(cur);
			if (cur.c >= (Math.abs(bX - cur.x) + Math.abs(bY - cur.y)))
				availB.add(cur);
		}
		if (availA.size() > 0 && availB.size() > 0) {
			for (int i = 0; i < availA.size(); i++) {
				ca = availA.get(i);
				for (int j = 0; j < availB.size(); j++) {
					cb = availB.get(j);
					res = ca.p + cb.p;
					if (ca.num == cb.num)
						res /= 2;
					sum = Math.max(sum, res);
				}
			}
		} else if (availA.size() > 0) {
			for (int i = 0; i < availA.size(); i++) {
				ca = availA.get(i);
				res = ca.p;
				sum = Math.max(sum, res);
			}
		} else if (availB.size() > 0) {
			for (int i = 0; i < availB.size(); i++) {
				cb = availB.get(i);
				res = cb.p;
				sum = Math.max(sum, res);
			}
		}
		ans += sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			Init();
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			moveA = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			moveB = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= a; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				arrayList.add(new Charger(i, y, x, c, p));
			}

			for (int i = 0; i <= m; i++) {
				checkCharge();
				movePerson(i);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}