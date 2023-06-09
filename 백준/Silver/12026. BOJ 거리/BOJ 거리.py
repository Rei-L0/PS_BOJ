n = int(input())
block = list(input())
dp = [123456789] * n
chk = ["B", "O", "J"]

dp[0] = 0

for i in range(n):
    x = chk.index(block[i])
    for j in range(i):
        if block[j] == chk[x - 1]:
            dp[i] = min(dp[i], dp[j] + (i - j) ** 2)
print(dp[-1] if dp[-1] != 123456789 else -1)
