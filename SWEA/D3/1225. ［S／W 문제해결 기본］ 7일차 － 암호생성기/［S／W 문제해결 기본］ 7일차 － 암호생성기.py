import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static int tc;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		String str;
		while ((str = bReader.readLine()) != null) {
			st = new StringTokenizer(str);
			tc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bReader.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			int count = 1;
			while (true) {
				int x = q.poll();
				if (x - count <= 0) {
					q.add(0);
					break;
				}
				q.add(x - count++);
				if (count == 6)
					count = 1;
			}
			sBuilder.append("#").append(tc);
			while (!q.isEmpty()) {
				sBuilder.append(" ").append(q.poll());
			}
			sBuilder.append('\n');
		}
		System.out.print(sBuilder);
	}

}