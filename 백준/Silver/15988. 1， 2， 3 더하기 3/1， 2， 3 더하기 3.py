import sys

t = int(sys.stdin.readline())

dp = [[0] for _ in range(10**6 + 1)]

dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, len(dp)):
    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    dp[i] = dp[i] % (10**9 + 9)

for _ in range(t):
    n = int(sys.stdin.readline())
    print(dp[n] % (10**9 + 9))
