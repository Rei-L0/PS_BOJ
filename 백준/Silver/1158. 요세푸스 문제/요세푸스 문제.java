import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sBuilder = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++)
			q.offer(i);

		int count = 0;
		sBuilder.append("<");
		while (!q.isEmpty()) {
			count++;
			if (count % k == 0) {
				sBuilder.append(q.poll());
				if (q.isEmpty())
					sBuilder.append(">");
				else
					sBuilder.append(", ");
			} else {
				q.offer(q.poll());
			}
		}
		System.out.println(sBuilder);
	}

}