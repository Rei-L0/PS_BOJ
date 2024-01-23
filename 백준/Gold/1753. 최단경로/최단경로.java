import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int dis;
	int next;

	public Node(int dis, int next) {
		this.dis = dis;
		this.next = next;
	}

}

public class Main {
	static final int MAX_VALUE = (int) Math.pow(2, 31);

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

		int[] distance = new int[v + 1];
		// Map에 경로의 정보 저장
		Map<Integer, Queue<Node>> graph = new HashMap<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (graph.containsKey(u)) {
				graph.get(u).offer(new Node(w, end));
				continue;
			}
			graph.put(u, new LinkedList<>());
			graph.get(u).offer(new Node(w, end));
		}

		// 모든 노드로의 거리 최대값으로 초기화
		for (int i = 1; i < v + 1; i++)
			distance[i] = MAX_VALUE;

		// 시작 노드 거리 0으로 설정
		distance[start] = 0;

		// 시작 노드 우선 순위 큐에 삽입
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		q.add(new Node(0, start));

		while (!q.isEmpty()) {
			Node curNode = q.poll();
			Queue<Node> nextNodes = graph.get(curNode.next);
			while (nextNodes != null && !nextNodes.isEmpty()) {
				Node nextNode = nextNodes.poll();
				if (curNode.dis + nextNode.dis < distance[nextNode.next]) {
					distance[nextNode.next] = curNode.dis + nextNode.dis;
					q.add(new Node(distance[nextNode.next], nextNode.next));
				}
			}
		}
		for (int i = 1; i < v + 1; i++) {
			if (distance[i] == MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
	}
}