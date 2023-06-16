dp = [[0] * 31 for i in range(31)]

for i in range(1, 31):
    for j in range(1, 31):
        if j == 1:
            dp[i][j] = i
        elif j == i:
            dp[i][j] = 1
        else:
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]

t = int(input())

for _ in range(t):
    x, y = map(int, input().split())
    print(dp[y][x])
