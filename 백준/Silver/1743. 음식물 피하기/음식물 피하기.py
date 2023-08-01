import sys


def dfs(x, y):
    stack = []
    stack.append((x, y))
    cnt = 1
    data[x][y] = 0

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if data[nx][ny] == 1:
                    stack.append((nx, ny))
                    data[nx][ny] = 0
                    cnt += 1
    return cnt


n, m, k = map(int, sys.stdin.readline().rstrip().split())
data = [[0] * m for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ans = 0

for _ in range(k):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    data[x - 1][y - 1] = 1


for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            ans = max(ans, dfs(i, j))

print(ans)
