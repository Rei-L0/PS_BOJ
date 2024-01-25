import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int n, ny, nx, ans = 10001;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int islandCount = 2;
    static Queue<Node> availNodes, island, findLoad;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        board = new int[n][n];
        availNodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 1) {
                    island = new LinkedList<>();
                    island.offer(new Node(x, y));
                    board[x][y] = islandCount;
                    while (!island.isEmpty()) {
                        boolean check = false;
                        Node curNode = island.poll();
                        for (int i = 0; i < 4; i++) {
                            nx = dx[i] + curNode.x;
                            ny = dy[i] + curNode.y;
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] == 1) {
                                island.offer(new Node(nx, ny));
                                board[nx][ny] = islandCount;
                            }
                            if (board[nx][ny] == 0) {
                                check = true;
                            }

                        }
                        if (check) {
                            availNodes.offer(new Node(curNode.x, curNode.y));
                        }
                    }
                    islandCount++;
                }
            }
        }

        while (!availNodes.isEmpty()) {
            Node node = availNodes.poll();
            int[][] dis = new int[n][n];
            int curIsland = board[node.x][node.y];
            findLoad = new LinkedList<>();
            findLoad.offer(new Node(node.x, node.y));
            while (!findLoad.isEmpty()) {
                Node curNode = findLoad.poll();
                for (int i = 0; i < 4; i++) {
                    nx = dx[i] + curNode.x;
                    ny = dy[i] + curNode.y;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 0 && dis[nx][ny] == 0) {
                        dis[nx][ny] = dis[curNode.x][curNode.y] + 1;
                        findLoad.offer(new Node(nx, ny));
                        continue;
                    }
                    if (board[nx][ny] != curIsland && board[nx][ny] != 0) {
                        ans = Math.min(ans, dis[curNode.x][curNode.y]);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}