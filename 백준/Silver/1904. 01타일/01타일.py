n = int(input())

dp = [0] * (10**6 + 1)
dp[1] = 1
dp[2] = 2

for i in range(3, len(dp)):
    dp[i] = dp[i - 1] + dp[i - 2]
    dp[i] %= 15746

print(dp[n])
