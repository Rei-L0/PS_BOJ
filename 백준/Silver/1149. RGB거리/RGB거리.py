n = int(input())
data = list()

for _ in range(n):
    x = list(map(int, input().split()))
    data.append(x)

dp = [[0 for _ in range(3)] for _ in range(n)]
for j in range(3):
    dp[0][j] = data[0][j]

for i in range(1, n):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + data[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + data[i][1]
    dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + data[i][2]

print(min(dp[-1]))
