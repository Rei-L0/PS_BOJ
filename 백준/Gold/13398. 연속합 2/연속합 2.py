n = int(input())

num = list(map(int, input().split()))

dp = [[-1001] * n for _ in range(2)]
min_num = dp[0][0] = num[0]
if n > 1:
    for i in range(1, n):
        dp[0][i] = max(dp[0][i - 1] + num[i], num[i])
        dp[1][i] = max(dp[1][i - 1] + num[i], dp[0][i - 1])
print(max(max(dp[1]), max(dp[0])))
