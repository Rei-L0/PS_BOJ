import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static void permutation(ArrayList<Integer> list, int[] arr, boolean[] visit) {
		if (list.size() == m) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				list.add(i + 1);
				permutation(list, arr, visit);
				visit[i] = false;
				list.remove(list.indexOf(i + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		permutation(new ArrayList<>(), arr, new boolean[n]);
	}
}