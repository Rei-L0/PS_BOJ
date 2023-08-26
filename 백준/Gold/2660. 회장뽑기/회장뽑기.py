import sys, heapq

INF = 51


def dik(start):
    distance = [INF] * (n + 1)
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        dis, now = heapq.heappop(q)
        if dis > distance[now]:
            continue
        for i in graph[now]:
            if distance[i[0]] > dis + i[1]:
                distance[i[0]] = dis + i[1]
                heapq.heappush(q, (distance[i[0]], i[0]))

    return max(distance[1:])


n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]

while True:
    s, e = map(int, sys.stdin.readline().rstrip().split())
    if s == -1 and e == -1:
        break
    graph[s].append((e, 1))
    graph[e].append((s, 1))

min_val = 51

for i in range(1, n + 1):
    x = dik(i)
    if min_val > x:
        answer = []
        answer.append(i)
        min_val = x
    elif min_val == x:
        answer.append(i)

print(f"{min_val} {len(answer)}")
print(*sorted(answer))
