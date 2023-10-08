n = int(input())

dp = [0, 0, 1, 2] + [0] * 10**6

for i in range(4, 10**6 + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) * (i - 1)
    dp[i] %= 10**9

print(dp[n])
