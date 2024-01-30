import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		for (int tc = 1; tc < 11; tc++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int maxValue, minValue, maxIndex = 0, minIndex = 0;
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			while (true) {
				maxValue = 0;
				minValue = 101;
				for (int i = 0; i < 100; i++) {
					if (box[i] > maxValue) {
						maxIndex = i;
						maxValue = box[i];
					}
					if (box[i] < minValue) {
						minIndex = i;
						minValue = box[i];
					}
				}
				if (n == 0) {
					System.out.println("#" + tc + " " + (box[maxIndex] - box[minIndex]));
					break;
				}
				box[minIndex] += 1;
				box[maxIndex] -= 1;
				n -= 1;
			}

		}
	}

}