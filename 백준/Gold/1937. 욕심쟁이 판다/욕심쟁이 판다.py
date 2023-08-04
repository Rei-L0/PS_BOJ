import sys
input = sys.stdin.readline
sys.setrecursionlimit(300000)
n = int(input())
array = [list(map(int, input().split())) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
dp = [[-1] * n for _ in range(n)]

def dfs(x, y):
    if dp[x][y] != -1:
        return dp[x][y]
    dp[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if array[nx][ny] > array[x][y]:
                dp[x][y] = max(dp[x][y], dfs(nx, ny)+1)
    return dp[x][y]

result = 0
for i in range(n):
    for j in range(n):
        result = max(result, dfs(i, j))
print(result)