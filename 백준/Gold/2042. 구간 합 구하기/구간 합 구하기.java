import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SegmentTree {
	long tree[];
	int treeSize;

	public SegmentTree(int arrSize) {
		// Tree의 높이는 전체 배열 개수를 log화 한 것
		// Leaf Node는 n개이고, 전체 개수는 각 Leaf Node를 더한 개수를 포함해야 하므로
		// log(n)의 높이로 구해야 한다.
		// Java의 log는 자연로그 함수이므로 log(2)를 통해 나누어 log2로 나누는 효과
		int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

		// Tree에 들어가는 Node의 개수는 2^(높이+1) 미만 개이다.
		this.treeSize = (int) Math.pow(2, h + 1);
		tree = new long[treeSize];
	}

	public long init(long[] nums, int node_idx, int start, int end) {
		// 만약 start == end라면 Leaf Node 라는 의미
		// 배열의 값을 그대로 저장한다.
		if (start == end) {
			return tree[node_idx] = nums[start];
		}

		// Leaf Node가 아닐 경우
		// 좌측 노드와 우측 노드의 합으로 구해진다.
		// 좌측 노드의 idx는 *2이며 우측은 *2+1이 된다.
		return tree[node_idx] = init(nums, node_idx * 2, start, (start + end) / 2)
				+ init(nums, node_idx * 2 + 1, (start + end) / 2 + 1, end);
	}

	public void update(int node_idx, int start, int end, int idx, long diff) {
		// 변경할 idx 값이 범위 밖이면 return
		if (idx < start || end < idx)
			return;

		// 변경된 차이만큼 영향 받는 각 node에 더해준다.
		tree[node_idx] += diff;

		// Leaf 노드까지 모든 노드의 값을 바꿔준다.
		if (start != end) {
			// 좌측 노드로
			update(node_idx * 2, start, (start + end) / 2, idx, diff);
			// 우측 노드로
			update(node_idx * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}
	}

	public long sum(int node_idx, int start, int end, int left, int right) {
		// 범위를 벗어날 경우 return
		if (left > end || right < start)
			return 0;
		// 범위 끝일 경우 바로 리턴
		if (left <= start && end <= right) {
			return tree[node_idx];
		}
		// 그 외의 경우 좌/우측으로 지속 탐색
		return sum(node_idx * 2, start, (start + end) / 2, left, right)
				+ sum(node_idx * 2 + 1, (start + end) / 2 + 1, end, left, right);

	}
}

public class Main {
	static long[] num;
	static int n, m, k, a, b;
	static long c;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		StringBuilder sBuilder = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new long[n + 1];

		SegmentTree segmentTree = new SegmentTree(n);

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(bufferedReader.readLine());
			num[i] = Long.parseLong(st.nextToken());
		}

		segmentTree.init(num, 1, 1, n);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(bufferedReader.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				segmentTree.update(1, 1, n, b, c - num[b]);
				num[b] = c;
			} else {
				sBuilder.append(segmentTree.sum(1, 1, n, b, (int) c)).append('\n');
			}
		}
		System.out.println(sBuilder);
	}
}