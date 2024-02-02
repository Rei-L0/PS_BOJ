import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int n;
	static ArrayDeque<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while (q.size() != 1) {
			q.poll();
			if (q.size() == 1)
				break;
			q.addLast(q.poll());
		}
		System.out.println(q.poll());
	}

}