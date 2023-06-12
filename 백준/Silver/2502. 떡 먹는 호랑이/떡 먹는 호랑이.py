d, k = map(int, input().split())

for i in range((k // 2) + 1, k):
    dp = [0] * (d + 1)
    dp[-1] = k
    dp[-2] = i
    for j in range(d - 2, 0, -1):
        dp[j] = dp[j + 2] - dp[j + 1]
        if dp[j] > dp[j + 1]:
            break
    if dp[1] < dp[2] and dp[1]:
        break
print(f"{dp[1]}\n{dp[2]}")
