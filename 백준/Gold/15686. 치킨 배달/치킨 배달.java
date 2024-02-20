import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] board;
	static ArrayList<Pos> chicken, house;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void combi(Pos[] arr, int count, int start) {
		if (count == m) {
			int dist = 0;
			for (int i = 0; i < house.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				for (int j = 0; j < arr.length; j++) {
					tmp = Math.min(calc(house.get(i), arr[j]), tmp);
				}
				dist += tmp;
			}
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			arr[count] = chicken.get(i);
			combi(arr, count + 1, i + 1);
		}
	}

	static int calc(Pos a, Pos b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					chicken.add(new Pos(i, j));
				if (board[i][j] == 1)
					house.add(new Pos(i, j));
			}
		}

		combi(new Pos[m], 0, 0);

		System.out.println(ans);
	}

}