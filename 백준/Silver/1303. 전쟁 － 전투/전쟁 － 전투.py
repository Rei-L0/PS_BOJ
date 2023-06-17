def dfs(x, y, color):
    stack = []
    stack.append((x, y))
    visit[y][x] = True
    cnt = 1

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if not visit[ny][nx] and data[ny][nx] == color:
                    stack.append((nx, ny))
                    cnt += 1
                    visit[ny][nx] = True
    return cnt**2


n, m = map(int, input().split())

data = [list(input()) for _ in range(m)]

visit = [[False] * n for _ in range(m)]

w = b = 0
for i in range(m):
    for j in range(n):
        if not visit[i][j]:
            x = dfs(j, i, data[i][j])
            if data[i][j] == "W":
                w += x
            else:
                b += x
print(f"{w} {b}")
