N = int(input())

dp = [[0 for _ in range(10)]for _ in range(1001)]

for i in range(10):
    dp[1][i] = 1

for i in range(2, 1001):
    for j in range(10):
        for k in range(10):
            if j >= k:
                dp[i][j] += dp[i-1][k] % 10007
            else:
                break

print(sum(dp[N]) % 10007)
