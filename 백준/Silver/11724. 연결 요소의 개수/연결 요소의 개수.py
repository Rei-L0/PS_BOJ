# 11724
import sys
from collections import deque


def bfs(start):
    queue = deque()
    queue.append(start)
    visit[start] = True

    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if not visit[i]:
                visit[i] = True
                queue.append(i)


n, m = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    graph[s].append(e)
    graph[e].append(s)

ans = 0
visit = [False] * (n + 1)
for i in range(1, n + 1):
    if not visit[i]:
        bfs(i)
        ans += 1
print(ans)
