import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static final int SIZE = 10;
	static boolean[][] board = new boolean[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int x = s; x < Math.min(101, s + SIZE); x++) {
				for (int y = e; y < Math.min(101, e + SIZE); y++) {
					board[x][y] = true;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (board[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}

}