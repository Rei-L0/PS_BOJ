n = int(input())

data = list(map(int, input().split()))

dp = [-1001 for _ in range(n)]

for i in range(n):
    dp[i] = max(data[i], dp[i - 1] + data[i])

print(max(dp))
