n = int(input())
data = list(map(int, input().split()))

dp = [1 for _ in range(n)]
for i in range(n):
    for j in range(i, n):
        if data[i] > data[j]:
            dp[j] = max(dp[i] + 1, dp[j])
print(max(dp))
