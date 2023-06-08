n = int(input())

num = list(map(int, input().split()))

dp = [1] * n

for i in range(n):
    for j in range(i + 1, n):
        if num[i] < num[j]:
            dp[j] = max(dp[i] + 1, dp[j])

for i in range(n):
    for j in range(i + 1, n):
        if num[i] > num[j]:
            dp[j] = max(dp[i] + 1, dp[j])
print(max(dp))
