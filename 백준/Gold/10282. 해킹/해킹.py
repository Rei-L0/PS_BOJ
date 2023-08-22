import sys, heapq

INF = 10**10 + 1


def dik(start):
    q = []
    dis = [INF] * (n + 1)
    heapq.heappush(q, (0, start))
    dis[start] = 0

    while q:
        distance, now = heapq.heappop(q)
        if distance > dis[now]:
            continue
        for i in graph[now]:
            if distance + i[1] < dis[i[0]]:
                dis[i[0]] = distance + i[1]
                heapq.heappush(q, (distance + i[1], i[0]))
    cnt = 0
    max_val = 0
    for i in dis:
        if i != INF:
            cnt += 1
            max_val = max(i, max_val)

    return print(f"{cnt} {max_val}")


t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    n, d, c = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(n + 1)]
    for _ in range(d):
        e, s, w = map(int, sys.stdin.readline().rstrip().split())
        graph[s].append((e, w))
    dik(c)
