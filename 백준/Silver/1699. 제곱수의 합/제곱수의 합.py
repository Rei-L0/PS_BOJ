n = int(input())

dp = [0 for _ in range(n + 1)]


for i in range(1, n + 1):
    if (i**0.5) % 1 == 0:
        dp[i] = 1
    else:
        dp[i] = dp[i - 1] + 1
        for j in range((int)(i**0.5), 0, -1):
            dp[i] = min(dp[i], dp[i - j**2] + dp[j**2])

print(dp[n])
