n = int(input())
data = list(map(int, input().split()))

dp = [data[i] for i in range(n)]
for i in range(n):
    for j in range(i + 1, n):
        if data[i] < data[j]:
            dp[j] = max(dp[j], dp[i] + data[j])
print(max(dp))
