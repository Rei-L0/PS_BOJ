# 14217
import sys
from collections import deque


def bfs(start):
    queue = deque([start])
    dis = [-1] * (n + 1)
    dis[start] = 0

    while queue:
        x = queue.popleft()
        for i in range(n + 1):
            if graph[x][i] != 0 and dis[i] == -1:
                dis[i] = dis[x] + 1
                queue.append(i)
    return dis


n, m = map(int, sys.stdin.readline().rstrip().split())
graph = [[0] * (n + 1) for _ in range(n + 1)]
INF = 123456789

for _ in range(m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    graph[s][e] = 1
    graph[e][s] = 1


q = int(sys.stdin.readline().rstrip())
for _ in range(q):
    a, i, j = map(int, sys.stdin.readline().rstrip().split())
    if a == 2:
        graph[i][j] = 0
        graph[j][i] = 0
    else:
        graph[i][j] = 1
        graph[j][i] = 1

    print(*bfs(1)[1:])
