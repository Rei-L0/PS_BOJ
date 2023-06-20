n = int(input())

dp = [-1] * (n + 1)
if n > 1:
    dp[2] = 1
if n > 4:
    dp[5] = 1

for i in range(2, n + 1):
    if dp[i - 2] > 0 and dp[i - 5] > 0:
        dp[i] = min(dp[i - 5], dp[i - 2]) + 1
    elif dp[i - 2] > 0:
        dp[i] = dp[i - 2] + 1
    elif dp[i - 5] > 0 and i > 4:
        dp[i] = dp[i - 5] + 1

print(dp[n])
