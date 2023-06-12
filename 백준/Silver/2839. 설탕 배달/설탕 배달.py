n = int(input())

dp = [123456789] * (n + 1)

for i in range(3, n + 1):
    if i % 5 == 0:
        dp[i] = i // 5
    if i % 3 == 0:
        dp[i] = i // 3
    dp[i] = min(dp[i - 3] + 1, dp[i - 5] + 1, dp[i])

print(dp[n] if dp[n] < 10000 else -1)
