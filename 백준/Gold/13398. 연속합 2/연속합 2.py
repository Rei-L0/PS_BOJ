N = int(input())

data = list(map(int, input().split()))

dp = [[0]*N for _ in range(2)]

if N == 1:
    print(data[0])
else:
    dp[0][0], dp[1][0] = data[0], data[0]

    for i in range(1, N):
        dp[0][i] = max(data[i], dp[0][i-1]+data[i])
        dp[1][i] = max(dp[0][i-1], dp[1][i-1]+data[i])

    print(max(max(dp[0]), max(dp[1])))
