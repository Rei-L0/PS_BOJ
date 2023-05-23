n = int(input())

data = list()

for _ in range(n):
    t, p = map(int, input().split())
    data.append((t, p))

dp = [0 for _ in range(n + 1)]

for i in range(n):
    for j in range(i + data[i][0], n + 1):
        if dp[i] + data[i][1] > dp[j]:
            dp[j] = dp[i] + data[i][1]
print(max(dp))
