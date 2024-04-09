import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigDecimal h = new BigDecimal(st.nextToken());
		BigDecimal i = new BigDecimal(st.nextToken());

		System.out.println(h.divide(i, 20, BigDecimal.ROUND_HALF_UP));
	}
}