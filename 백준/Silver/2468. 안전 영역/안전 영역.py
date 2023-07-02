from collections import deque


def bfs(sx, sy, visit, lv):
    queue = deque()
    queue.append((sx, sy))
    visit[sy][sx] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if data[ny][nx] > lv and not visit[ny][nx]:
                    queue.append((nx, ny))
                    visit[ny][nx] = True


n = int(input())

data = [list(map(int, input().split())) for _ in range(n)]
minimum = 100
maximum = 1
for i in range(n):
    maximum = max(maximum, max(data[i]))

ans = 0

for level in range(maximum + 1):
    res = 0
    visit = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if data[i][j] > level and not visit[i][j]:
                bfs(j, i, visit, level)
                res += 1
    ans = max(ans, res)

print(ans)
