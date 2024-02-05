import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Element implements Comparable<Element> {
	int h;
	int idx;

	public Element(int h, int idx) {
		this.h = h;
		this.idx = idx;
	}

	@Override
	public int compareTo(Element o) {
		return this.h - o.h;
	}

}

public class Main {
	static int n;
	static int[] h;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		h = new int[n + 1];
		ans = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Element> pq = new PriorityQueue<>();
		for (int i = n; i > 0; i--) {
			while (!pq.isEmpty() && h[i] > pq.peek().h) {
				ans[pq.poll().idx] = i;
			}
			pq.add(new Element(h[i], i));
		}
		for (int i = 1; i < n + 1; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

}