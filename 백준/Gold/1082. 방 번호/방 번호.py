n = int(input())
data = list(map(int, input().split()))
m = int(input())
dp = [""] * (m + 1)
x = 0
answer = 0
for i in range(n):
    if data[i] <= m:
        dp[data[i]] = str(i)

while x <= m:
    if dp[x] != "":
        for i in range(n):
            if x + data[i] <= m:
                if dp[x + data[i]] == "":
                    dp[x + data[i]] = dp[x] + str(i)
                else:
                    if int(dp[x + data[i]]) < int(dp[x] + str(i)):
                        dp[x + data[i]] = dp[x] + str(i)
            answer = max(answer, int(dp[x]))
    x += 1


print(answer)
