import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        sb.append(1 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(1 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(8 - Integer.parseInt(st.nextToken())).append(" ");
        System.out.println(sb);
    }

}