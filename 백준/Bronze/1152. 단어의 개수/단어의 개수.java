import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		if (" ".equals(s))
			System.out.println(0);
		else
			System.out.println(s.trim().split(" ").length);
	}

}