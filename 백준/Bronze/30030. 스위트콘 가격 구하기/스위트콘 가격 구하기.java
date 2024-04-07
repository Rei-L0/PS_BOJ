import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        int a = (int) (b / 1.1f);

        System.out.println(a);
        br.close();
    }
}