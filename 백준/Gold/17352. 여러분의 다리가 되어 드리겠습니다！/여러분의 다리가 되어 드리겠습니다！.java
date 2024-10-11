import java.util.Scanner;

public class Main {

    // Union-Find 클래스
    static class UnionFind {

        private int[] parent;
        private int[] rank;

        // 초기화: 각 섬을 자신을 부모로 설정
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // find 연산: 경로 압축 사용
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // union 연산: 랭크 기반으로 합침
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 섬의 개수 N
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(n);

        // N - 2개의 다리 정보를 입력받아 union 처리
        for (int i = 0; i < n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            uf.union(a, b);
        }

        int firstIsland = -1;
        int secondIsland = -1;

        // 두 개의 다른 컴포넌트를 찾는다
        for (int i = 1; i <= n; i++) {
            if (firstIsland == -1) {
                firstIsland = uf.find(i);
            } else if (uf.find(i) != firstIsland) {
                secondIsland = uf.find(i);
                break;
            }
        }

        // 다리를 연결할 두 섬 출력
        System.out.println(firstIsland + " " + secondIsland);
    }
}
