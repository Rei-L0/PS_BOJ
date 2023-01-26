N = int(input())

dp = [[0 for _ in range(N)] for _ in range(N)]

data = []

for i in range(N):
    a = list(map(int, input().split()))
    data.append(a)

dp[0][0] = data[0][0]

if N > 1:
    for i in range(N):
        for j in range(len(data[i])):
            dp[i][j] = data[i][j]+max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[N-1]))
