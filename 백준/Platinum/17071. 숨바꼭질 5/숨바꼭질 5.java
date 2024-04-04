import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 500_001;

	static int n, k, ans;

	static int[][] su;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Deque<Integer> suQ = new ArrayDeque<>();

		su = new int[2][MAX];

		Arrays.fill(su[0], -1);
		Arrays.fill(su[1], -1);

		su[0][n] = 0;

		suQ.add(n);

		boolean isFinish = false;
		int time = 0;
		int right = k;

		while (true) {
			int size = suQ.size();
			if (size == 0) {
				ans = -1;
				break;
			}
			while (size-- > 0) {
				int now = suQ.poll();
				if (now - 1 > -1 && su[time % 2][now - 1] == -1) {
					su[time % 2][now - 1] = time + 1;
					suQ.add(now - 1);
				}
				if (now + 1 < MAX && su[time % 2][now + 1] == -1) {
					su[time % 2][now + 1] = time + 1;
					suQ.add(now + 1);
				}
				if (now * 2 < MAX && su[time % 2][now * 2] == -1) {
					su[time % 2][now * 2] = time + 1;
					suQ.add(now * 2);
				}
			}
			if (right + time < MAX) {
				right += time;
				if (!isFinish) {
					isFinish = finish(time, su[0][right]);
					if (isFinish) {
						ans = time;
						break;
					}
					isFinish = finish(time, su[1][right]);
					if (isFinish) {
						ans = time;
						break;
					}
				}
			} else {
				isFinish = true;
				ans = -1;
			}
			if (isFinish)
				break;

			time++;
		}
		System.out.println(ans);
	}

	static boolean finish(int x, int y) {
		if (x < y || y == -1)
			return false;
		return (x - y) % 2 == 0;
	}
}