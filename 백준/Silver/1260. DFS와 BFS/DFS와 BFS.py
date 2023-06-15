from collections import deque


def dfs(start):
    stack = []
    visit = [False] * (n + 1)
    stack.append(start)

    while stack:
        x = stack.pop()
        if not visit[x]:
            print(x, end=" ")
            visit[x] = True
        for i in sorted(graph[x], reverse=True):
            if not visit[i]:
                stack.append(i)


def bfs(start):
    queue = deque()
    visit = [False] * (n + 1)
    visit[start] = True
    queue.append(start)

    while queue:
        x = queue.popleft()
        print(x, end=" ")
        for i in graph[x]:
            if not visit[i]:
                visit[i] = True
                queue.append(i)


n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

for i in graph:
    i.sort()

dfs(v)
print()
bfs(v)
