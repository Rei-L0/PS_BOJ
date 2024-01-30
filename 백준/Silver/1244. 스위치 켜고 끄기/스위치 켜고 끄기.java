import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, stuNum, stu, num;
	static int[] on;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		on = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			on[i] = Integer.parseInt(st.nextToken());
		}
		stuNum = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for (int i = 0; i < stuNum; i++) {
			st = new StringTokenizer(br.readLine());
			stu = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			if (stu == 1) {
				for (int j = num; j < n + 1; j++) {
					if (j % num == 0) {
						if (on[j] == 1)
							on[j] = 0;
						else
							on[j] = 1;
					}
				}
			} else {
				int count = 0;
				while (true) {
					count++;
					if (num - count == 0 || num + count == n + 1) {
						count -= 1;
						break;
					}
					if (on[num - count] != on[num + count]) {
						count -= 1;
						break;
					}
				}
				for (int j = num - count; j <= num + count; j++) {
					if (on[j] == 1)
						on[j] = 0;
					else
						on[j] = 1;
				}
			}
		}
		for (int k = 1; k < on.length; k++) {
			if ((k - 1) % 20 == 0 && k != 1)
				System.out.println();
			System.out.print(on[k] + " ");
		}
	}

}