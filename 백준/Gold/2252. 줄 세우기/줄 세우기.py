from collections import deque

n, m = map(int, input().split())
connection = [0] * (n + 1)
connection[0] = -1

graph = [[] for _ in range(n + 1)]
queue = deque()

for _ in range(m):
    s, e = map(int, input().split())
    connection[e] += 1
    graph[s].append(e)

for i in range(1, n + 1):
    if connection[i] == 0:
        queue.append(i)

while queue:
    x = queue.popleft()
    print(x, end=" ")
    for connect_idx in graph[x]:
        connection[connect_idx] -= 1
        if connection[connect_idx] == 0:
            queue.append(connect_idx)
