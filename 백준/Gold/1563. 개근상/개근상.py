n = int(input())

dp = [[0] * 2 for _ in range(1001)]
dp_l = [0 for _ in range(1001)]
dp_a = [[[0] * 2 for _ in range(2)] for _ in range(1001)]

dp_l[1] = dp[1][0] = dp_a[1][0][0] = 1

for i in range(2, 1001):
    # O (L 포함)
    dp[i][1] += dp_l[i - 1]
    dp[i][1] += dp[i - 1][1]
    dp[i][1] += dp_a[i - 1][1][0]
    dp[i][1] += dp_a[i - 1][1][1]

    # O (L 미포함)
    dp[i][0] += dp[i - 1][0]
    dp[i][0] += dp_a[i - 1][0][0]
    dp[i][0] += dp_a[i - 1][0][1]

    # L
    dp_l[i] += dp[i - 1][0]
    dp_l[i] += dp_a[i - 1][0][0]
    dp_l[i] += dp_a[i - 1][0][1]

    # A
    dp_a[i][0][0] += dp[i - 1][0]
    dp_a[i][0][1] += dp_a[i - 1][0][0]
    dp_a[i][1][0] += dp_l[i - 1]
    dp_a[i][1][0] += dp[i - 1][1]
    dp_a[i][1][1] += dp_a[i - 1][1][0]

print((sum(dp[n]) + dp_l[n] + sum(dp_a[n][0]) + sum(dp_a[n][1])) % 10**6)
