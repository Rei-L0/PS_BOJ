import sys, heapq


def dik(s):
    q = []
    heapq.heappush(q, (0, s))
    distance[s] = 0

    while q:
        dis, now = heapq.heappop(q)
        if dis > distance[now]:
            continue
        for i in food[now]:
            if dis + i[1] < distance[i[0]]:
                distance[i[0]] = dis + i[1]
                heapq.heappush(q, (dis + i[1], i[0]))


n, m = map(int, sys.stdin.readline().rstrip().split())
INF = 10**10
distance = [INF] * (n + 1)

food = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, w = map(int, sys.stdin.readline().rstrip().split())
    food[s].append((e, w))
    food[e].append((s, w))

dik(1)
print(distance[n])
