n = int(input())

INF = 123456789

cost = [[INF] * (n + 1) for _ in range(n + 1)]

for _ in range(int(input())):
    s, e, w = map(int, input().split())
    cost[s][e] = min(w, cost[s][e])


for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                cost[i][j] = 0
                continue
            cost[i][j] = min(cost[i][k] + cost[k][j], cost[i][j])


for i in range(1, n + 1):
    for j in range(1, n + 1):
        print(cost[i][j] if cost[i][j] != INF else 0, end=" ")
    print()
