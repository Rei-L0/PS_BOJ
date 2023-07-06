import sys, heapq

INF = 10**10

n, m = map(int, sys.stdin.readline().rstrip().split())
dist = [INF] * (n + 1)
bungi = list(map(int, sys.stdin.readline().rstrip().split()))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        distance, now = heapq.heappop(q)
        if dist[now] < distance or bungi[now] == 1:
            continue
        for i in road[now]:
            if distance + i[1] < dist[i[0]]:
                dist[i[0]] = distance + i[1]
                heapq.heappush(q, (distance + i[1], i[0]))


road = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e, v = map(int, sys.stdin.readline().rstrip().split())
    road[s].append((e, v))
    road[e].append((s, v))

dijkstra(0)
if dist[-2] == INF:
    print(-1)
else:
    print(dist[-2])
