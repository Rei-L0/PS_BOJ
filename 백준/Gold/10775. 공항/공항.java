import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int g, p, ans;

	static int[] port;

	static int find(int x) {
		if (port[x] == x)
			return x;
		return port[x] = find(port[x]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		g = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());

		port = new int[g + 1];
		for (int i = 0; i < g + 1; i++)
			port[i] = i;

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int plane = Integer.parseInt(st.nextToken());
			int now = find(plane);
			if (now == 0)
				break;
			port[now] = now - 1;
			ans++;
		}

		System.out.println(ans);

	}
}