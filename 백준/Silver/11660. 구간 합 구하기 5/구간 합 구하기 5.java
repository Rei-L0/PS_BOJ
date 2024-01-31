import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int[][] dp;
	private static int[][] input;
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		input = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1]+ input[i][j];	//누적합
			}
		}
		

		
		int x1,y1,x2,y2;
		
		for(int i=0;i<M;i++) {
			int sm =0;
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int j=x1;j<=x2;j++) {
				sm += (dp[j][y2]-dp[j][y1-1]);
			}
			out.write(sm + "\n");
		}	
		out.flush();
        out.close();
	}
}