t = int(input())

dp = [[0] * 10 for _ in range(65)]

for i in range(1, 65):
    for j in range(10):
        if i == 1:
            dp[i][j] = 1
        else:
            dp[i][j] = sum(dp[i - 1][: j + 1])

for _ in range(t):
    n = int(input())
    print(sum(dp[n]))
