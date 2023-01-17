n = int(input())

wine = [0]
dp = [0]*10001

for _ in range(n):
    data = int(input())
    wine.append(data)

dp[1] = wine[1]
if n > 1:
    dp[2] = wine[1]+wine[2]
if n > 2:
    dp[3] = max(dp[2], wine[1]+wine[3], wine[2]+wine[3])

for i in range(3, n+1):
    dp[i] = max(wine[i]+dp[i-2], wine[i]+wine[i-1]+dp[i-3], dp[i-1])

print(dp[n])
