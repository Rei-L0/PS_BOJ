from collections import deque


def bfs(sx, sy):
    queue = deque()
    queue.append((sx, sy))
    visit = [[False] * m for _ in range(n)]
    visit[sy][sx] = True
    ans = [[0] * m for _ in range(n)]

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < m and -1 < ny < n:
                if data[ny][nx] == 1 and not visit[ny][nx]:
                    visit[ny][nx] = True
                    ans[ny][nx] = ans[y][x] + 1
                    queue.append((nx, ny))
    return ans


n, m = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if data[i][j] == 2:
            res = bfs(j, i)

for i in range(n):
    for j in range(m):
        if data[i][j] == 1 and res[i][j] == 0:
            res[i][j] = -1
    print(*res[i])
