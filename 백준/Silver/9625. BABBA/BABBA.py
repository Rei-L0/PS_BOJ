k = int(input())

dp = [[0] * (2) for _ in range(k + 1)]

dp[1][1] = 1
if k > 1:
    dp[2][0] = 1
    dp[2][1] = 1
if k > 2:
    dp[3][0] = 1
    dp[3][1] = 2
if k > 3:
    for i in range(4, k + 1):
        dp[i][0] = dp[i - 1][1]
        dp[i][1] = dp[i - 1][0] + dp[i - 1][1]

print(f"{dp[k][0]} {dp[k][1]}")
