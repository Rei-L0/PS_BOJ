n, k = map(int, input().split())

data = [0] + [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * (k + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(k + 1):
        if j < data[i][0]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], data[i][1] + dp[i - 1][j - data[i][0]])

print(dp[n][k])
