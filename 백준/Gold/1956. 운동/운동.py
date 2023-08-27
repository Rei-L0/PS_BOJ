import sys

INF = 123456789
v, e = map(int, sys.stdin.readline().rstrip().split())

graph = [[INF] * (v + 1) for _ in range(v + 1)]

for _ in range(e):
    start, end, weight = map(int, sys.stdin.readline().rstrip().split())
    graph[start][end] = weight

for k in range(1, v + 1):
    for i in range(1, v + 1):
        for j in range(1, v + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

answer = INF
for i in range(1, v + 1):
    answer = min(answer, graph[i][i])

if answer == INF:
    print(-1)
else:
    print(answer)
