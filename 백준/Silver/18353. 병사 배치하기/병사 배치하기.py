n = int(input())
data = list(map(int, input().split()))

dp = [1] * n

for i in range(len(data)):
    for j in range(i + 1, len(data)):
        if data[i] > data[j]:
            dp[j] = max(dp[i] + 1, dp[j])

print(n - max(dp))
