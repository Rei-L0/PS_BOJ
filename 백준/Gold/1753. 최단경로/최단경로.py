import sys, heapq


def dik(s):
    heap = []
    heapq.heappush(heap, (0, s))
    distance[s] = 0

    while heap:
        dis, now = heapq.heappop(heap)
        if distance[now] < dis:
            continue
        for i in graph[now]:
            if dis + i[1] < distance[i[0]]:
                distance[i[0]] = dis + i[1]
                heapq.heappush(heap, (dis + i[1], i[0]))


v, e = map(int, sys.stdin.readline().rstrip().split())
s = int(sys.stdin.readline())
graph = [[] for _ in range(v + 1)]

for _ in range(e):
    start, end, w = map(int, sys.stdin.readline().rstrip().split())
    graph[start].append((end, w))

INF = 10**10
distance = [INF] * (v + 1)

dik(s)

for i in range(1, v + 1):
    if i == s:
        print(0)
    elif distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
