import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    static int[] num, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        num = new int[n];
        tree = new int[getTreeSize()];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        init(0, n - 1, 1);

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (op == 1) {
                num[a - 1] = v;
                update(0, n - 1, 1, a - 1);
            } else {
                sb.append(getMin(0, n - 1, 1, a - 1, v - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, h) - 1;
    }

    static int init(int s, int e, int node) {
        if (s == e) {
            return tree[node] = num[s];
        }
        int mid = (s + e) / 2;
        return tree[node] = Math.min(init(s, mid, node * 2), init(mid + 1, e, node * 2 + 1));
    }

    static int update(int s, int e, int node, int idx) {
        if (s > idx || e < idx) {
            return tree[node];
        }
        if (s == e) {
            return tree[node] = num[idx];
        }
        int mid = (s + e) / 2;
        return tree[node] = Math.min(update(s, mid, node * 2, idx),
            update(mid + 1, e, node * 2 + 1, idx));
    }

    static int getMin(int s, int e, int node, int l, int r) {
        if (r < s || l > e) {
            return Integer.MAX_VALUE;
        }
        if (s >= l && e <= r) {
            return tree[node];
        }
        int mid = (s + e) / 2;
        return Math.min(getMin(s, mid, node * 2, l, r),
            getMin(mid + 1, e, node * 2 + 1, l, r));

    }

}