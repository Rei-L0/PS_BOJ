import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, t, k, w;
	static int[] time, in;
	static BufferedReader bReader;
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph;

	static class Info implements Comparable<Info> {
		int time;
		int num;

		public Info(int time, int num) {
			this.time = time;
			this.num = num;
		}

		@Override
		public int compareTo(Info o) {
			return this.time - o.time;
		}
	}

	static void init() throws Exception {
		st = new StringTokenizer(bReader.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		time = new int[n + 1];
		in = new int[n + 1];

		st = new StringTokenizer(bReader.readLine().trim());
		for (int i = 1; i < n + 1; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bReader.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			in[e]++;
		}

		st = new StringTokenizer(bReader.readLine().trim());
		w = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bReader.readLine().trim());
		t = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < t; tc++) {
			init();
			PriorityQueue<Info> pq = new PriorityQueue<>();
			for (int i = 1; i < n + 1; i++) {
				if (in[i] == 0)
					pq.add(new Info(time[i], i));
			}
			while (!pq.isEmpty()) {
				Info now = pq.poll();
				for (int i = 0; i < graph.get(now.num).size(); i++) {
					int out = graph.get(now.num).get(i);
					in[out]--;
					if (in[out] == 0) {
						time[out] += time[now.num];
						pq.add(new Info(time[out], out));
					}
				}
			}
			System.out.println(time[w]);
		}
	}
}