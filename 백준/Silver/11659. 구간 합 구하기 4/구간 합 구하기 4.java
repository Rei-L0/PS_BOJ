import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int[] dp = new int [100004];
	private static int[] input = new int [100004];
	static int N,M;
	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			dp[i] = dp[i-1]+input[i];	//dp 배열 더해나간다.
		}
		int x,y;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			System.out.println(dp[y]-dp[x-1]);
		}

		
		
	}

}