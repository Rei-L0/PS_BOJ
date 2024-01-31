import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void print() {
		for(int i=0;i<M;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static void combi(int cnt,int start) {
		if(cnt == M) {
			print();
			return;
		}
		for(int i=start;i<=N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = i;
			combi(cnt+1,i+1);
			visited[i] =false;
		}
		
	}
	static boolean[] visited = new boolean[10];
	static int[] arr = new int[10];
	static int N,M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		combi(0,1);
		
		
		
		
	}

}