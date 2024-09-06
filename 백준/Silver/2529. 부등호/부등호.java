import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<String> ans = new ArrayList<>();
    static char[] budungho;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        budungho = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budungho[i] = st.nextToken().charAt(0);
        }
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            visited[i] = true;
            solve(0, i, sb, visited);
            visited[i] = false;
        }

        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1)); // 가장 마지막 값
        System.out.println(ans.get(0)); // 가장 첫 번째 값
    }

    static void solve(int n, int before, StringBuilder sb, boolean[] visited) {
        if (n == N) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (budungho[n] == '<') {
                if (before < i && !visited[i]) {
                    StringBuilder next = new StringBuilder();
                    next.append(sb.toString()).append(i);
                    visited[i] = true;
                    solve(n + 1, i, next, visited);
                    visited[i] = false;
                }
            }
            if (budungho[n] == '>') {
                if (before > i && !visited[i]) {
                    StringBuilder next = new StringBuilder();
                    next.append(sb.toString()).append(i);
                    visited[i] = true;
                    solve(n + 1, i, next, visited);
                    visited[i] = false;
                }
            }
        }
    }
}

