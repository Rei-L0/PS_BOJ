n = int(input())
dp = [i for i in range(101)]
for i in range(7, 101):
    for j in range(3, i):
        dp[i] = max(dp[i], dp[i - j] * (j - 1))
print(dp[n])
