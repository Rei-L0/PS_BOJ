import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13549
public class Main {
	static int n, k;
	final static int MAX = (int) Math.pow(10, 6) + 1;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] move = new int[MAX];
		boolean[] visit = new boolean[MAX];

		for (int i = 0; i < MAX; i++)
			move[i] = MAX;

		move[n] = 0;
		queue.offer(n);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			visit[x] = true;
			if (x == k) {
				System.out.println(move[x]);
				break;
			}
			if (x * 2 < MAX && visit[x * 2] == false) {
				move[x * 2] = move[x];
				queue.offer(x * 2);
			}
			if (x - 1 > -1 && visit[x - 1] == false) {
				move[x - 1] = Math.min(move[x] + 1, move[x - 1]);
				queue.offer(x - 1);
			}
			if (x + 1 < MAX && visit[x + 1] == false) {
				move[x + 1] = Math.min(move[x] + 1, move[x + 1]);
				queue.offer(x + 1);
			}
		}

	}
}