import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static ArrayDeque<Work> deque = new ArrayDeque<>();

	static class Work {
		int score;
		int time;

		public Work(int score, int time) {
			this.score = score;
			this.time = time;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			// 업무 없을 때
			if (op == 0) {
				if(deque.isEmpty())
					continue;
				deque.peekLast().time--;
			} else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				deque.add(new Work(score, time - 1));
			}
			// 진행한 업무가 끝났을 경우 점수 획득
			if (deque.peekLast().time == 0) {
				ans += deque.pollLast().score;
			}
		}

		System.out.println(ans);
	}

}