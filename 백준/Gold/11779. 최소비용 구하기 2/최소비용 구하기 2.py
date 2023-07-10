import sys, heapq


def dik(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    dir[start].append(start)

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in bus[now]:
            if i[1] + dist < distance[i[0]]:
                distance[i[0]] = dist + i[1]
                heapq.heappush(q, (dist + i[1], i[0]))
                if not dir[i[0]]:
                    for j in dir[now]:
                        dir[i[0]].append(j)
                    dir[i[0]].append(i[0])
                else:
                    dir[i[0]].clear()
                    for j in dir[now]:
                        dir[i[0]].append(j)
                    dir[i[0]].append(i[0])


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
bus = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, w = map(int, sys.stdin.readline().rstrip().split())
    bus[s].append((e, w))

s, e = map(int, sys.stdin.readline().rstrip().split())

INF = 10**10
distance = [INF] * (n + 1)
dir = [[] for _ in range(n + 1)]

dik(s)

print(distance[e])
print(len(dir[e]))
print(*dir[e])
