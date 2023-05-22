n = int(input())
card = [0] + list(map(int, input().split()))

dp = [0] * (n + 1)

for i in range(1, n + 1):
    dp[i] = card[i]
    for j in range(1, i + 1):
        dp[i] = min(dp[i - j] + card[j], dp[i])
print(dp[n])
