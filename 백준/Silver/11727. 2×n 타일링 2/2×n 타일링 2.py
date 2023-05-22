n = int(input())

dp = [0] * (n + 1)
dp[1] = 1
if len(dp) > 2:
    dp[2] = 3
if len(dp) > 3:
    dp[3] = 5

for i in range(4, n + 1):
    dp[i] = dp[i - 2] * 2 + dp[i - 1]
    dp[i] = dp[i] % 10007
print(dp[n])
