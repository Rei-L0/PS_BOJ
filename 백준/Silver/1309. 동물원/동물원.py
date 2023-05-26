n = int(input())

dp = [[0] * 3 for _ in range(n + 1)]

for i in range(3):
    dp[1][i] = 1
if n > 1:
    for i in range(2, n + 1):
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
        dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
        dp[i][2] = dp[i - 1][0] + dp[i - 1][1]
        for j in range(3):
            dp[i][j] %= 9901
print(sum(dp[n]) % 9901)
