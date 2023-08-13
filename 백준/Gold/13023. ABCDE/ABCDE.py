import sys


def back(idx, depth):
    global ans
    if not graph[idx]:
        return
    if depth == 5:
        ans = 1
        return
    for i in graph[idx]:
        if not visited[i]:
            visited[i] = True
            back(i, depth + 1)
            visited[i] = False


n, m = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n)]
ans = 0
visited = [False] * n

for _ in range(m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    graph[s].append(e)
    graph[e].append(s)

for i in range(n):
    back(i, 0)
    if ans == 1:
        break
print(ans)
