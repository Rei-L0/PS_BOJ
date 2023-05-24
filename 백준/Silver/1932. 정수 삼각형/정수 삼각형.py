n = int(input())
data = list()

for _ in range(n):
    x = list(map(int, input().split()))
    data.append(x)

dp = [[0 for _ in range(i + 1)] for i in range(n)]

dp[0][0] = data[0][0]
ans = 0
if n > 1:
    for i in range(1, n):
        for j in range(len(dp[i])):
            if j == 0:
                dp[i][j] = dp[i - 1][j] + data[i][j]
            elif j == len(dp[i]) - 1:
                dp[i][j] = dp[i - 1][j - 1] + data[i][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + data[i][j]
        ans = max(dp[i])
else:
    ans = data[0][0]
print(ans)
