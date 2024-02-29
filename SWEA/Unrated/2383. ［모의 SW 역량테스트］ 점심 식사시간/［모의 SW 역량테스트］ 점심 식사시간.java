import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static int t, n, ans;

	static int[][] board;

	static ArrayList<Pos> person;
	static ArrayList<Pos> stair;

	static StringTokenizer st;
	static BufferedReader bReader;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;
		person = new ArrayList<>();
		stair = new ArrayList<>();

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bReader.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					person.add(new Pos(i, j));
				}
				if (board[i][j] > 1) {
					stair.add(new Pos(i, j));
				}
			}
		}
	}

	// 사람마다 내려갈 계단 선택
	static void solve(int start, int count, int end, boolean[] check) {
		if (count == end) {
			int idx = 0;
			int[] arr = new int[end];
			int idx2 = 0;
			int[] arr2 = new int[person.size() - end];
			for (int x = 0; x < person.size(); x++) {
				if (check[x])
					arr[idx++] = x;
				else
					arr2[idx2++] = x;
			}
			ans = Math.min(ans, move(arr, arr2));
			return;
		}
		for (int i = start; i < person.size(); i++) {
			check[i] = true;
			solve(i + 1, count + 1, end, check);
			check[i] = false;
		}
	}

	static int move(int[] first, int[] second) {
		int count = 0;

		int firstTime = 0;
		int secondTime = 0;

		if (first.length != 0)
			firstTime = calc(first, 0);
		if (second.length != 0)
			secondTime = calc(second, 1);

		return Math.max(firstTime, secondTime);
	}

	static int calc(int[] arr, int num) {
		int res = 0;
		Pos s = stair.get(num);
		int time = board[s.x][s.y];

		ArrayList<Integer> list = new ArrayList<>();

		for (int x : arr) {
			Pos now = person.get(x);
			int dis = Math.abs(now.x - s.x) + Math.abs(now.y - s.y);
			list.add(dis);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			res = list.get(i) + time + 1;
			if (i + 1 > 3) {
				// 대기중일 때
				if (list.get(i - 3) + time + 1 > list.get(i)) {
					res = list.get(i - 3) + time + 1 + time;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			init();
			for (int i = 0; i <= person.size(); i++)
				solve(0, 0, i, new boolean[person.size()]);
			System.out.println("#" + tc + " " + ans);
		}

	}
}