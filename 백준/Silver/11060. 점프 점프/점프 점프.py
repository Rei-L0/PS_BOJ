n = int(input())
miro = list(map(int, input().split()))

dp = [0] * n

for i in range(n):
    if i > 0 and dp[i] == 0:
        break
    for j in range(i + 1, min(i + miro[i] + 1, n)):
        if dp[j] == 0:
            dp[j] = dp[i] + 1
        else:
            dp[j] = min(dp[i] + 1, dp[j])
print(dp[-1] if dp[-1] or n == 1 else -1)
