# 1245
n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 1, 1, -1, -1, -1, 0, 0]
dy = [1, 0, -1, 1, 0, -1, 1, -1]
visited = [[False] * m for _ in range(n)]
ans = 0


def dfs(sx, sy):
    stack = []
    stack.append((sx, sy))
    check = True

    while stack:
        x, y = stack.pop()
        visited[x][y] = True

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if data[nx][ny] == data[sx][sy] and not visited[nx][ny]:
                    stack.append((nx, ny))
                if data[nx][ny] > data[x][y]:
                    check = False
    return check


for i in range(n):
    for j in range(m):
        if data[i][j] > 0 and not visited[i][j]:
            if dfs(i, j):
                ans += 1

print(ans)
