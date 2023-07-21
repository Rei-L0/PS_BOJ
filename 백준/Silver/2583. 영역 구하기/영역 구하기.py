import sys


def dfs(x, y):
    stack = []
    stack.append((x, y))
    data[x][y] = 1
    cnt = 1

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if data[nx][ny] == 0:
                    data[nx][ny] = 1
                    cnt += 1
                    stack.append((nx, ny))
    return cnt


n, m, k = map(int, sys.stdin.readline().rstrip().split())
data = [[0] * m for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ans = []

for _ in range(k):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rstrip().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            data[j][i] = 1

for i in range(n):
    for j in range(m):
        if data[i][j] == 0:
            ans.append(dfs(i, j))
print(len(ans))
print(*sorted(ans))
