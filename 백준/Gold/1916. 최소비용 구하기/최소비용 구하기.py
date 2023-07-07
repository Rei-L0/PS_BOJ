import sys, heapq


def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in bus[now]:
            if dist + i[1] < distance[i[0]]:
                distance[i[0]] = dist + i[1]
                heapq.heappush(q, (dist + i[1], i[0]))
    return print(f"{distance[end]}")


INF = 10**10
n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
bus = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e, v = map(int, sys.stdin.readline().rstrip().split())
    bus[s].append((e, v))
s, e = map(int, sys.stdin.readline().rstrip().split())

distance = [INF] * (n + 1)

dijkstra(s, e)
