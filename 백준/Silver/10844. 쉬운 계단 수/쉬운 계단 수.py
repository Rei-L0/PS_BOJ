N = int(input())

dp = [[0 for _ in range(10)] for i in range(101)]

for i in range(1, 10):
    dp[1][i] = 1

for i in range(2, 101):
    for j in range(10):
        if j == 0:
            dp[i][1] += dp[i-1][j] % 1000000000
        elif j == 9:
            dp[i][8] += dp[i-1][j] % 1000000000
        else:
            dp[i][j-1] += dp[i-1][j] % 1000000000
            dp[i][j+1] += dp[i-1][j] % 1000000000

print(sum(dp[N]) % 1000000000)
