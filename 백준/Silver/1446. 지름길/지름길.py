n, d = map(int, input().split())

road = [list(map(int, input().split())) for _ in range(n)]
road.sort()
dp = [i for i in range(d + 1)]

for i in range(n):
    if road[i][1] > d:
        continue
    if (road[i][1] - road[i][0]) > road[i][2]:
        dp[road[i][1]] = min(dp[road[i][1]], dp[road[i][0]] + road[i][2])
    for j in range(1, d + 1):
        dp[j] = min(dp[j], dp[j - 1] + 1)

print(dp[d])
