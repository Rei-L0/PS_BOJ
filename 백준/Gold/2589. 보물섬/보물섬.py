from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    zido2 = [[0] * w for _ in range(h)]
    zido2[y][x] = 1

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    ans = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < w and -1 < ny < h:
                if zido[ny][nx] == "L" and zido2[ny][nx] == 0:
                    zido2[ny][nx] = zido2[y][x] + 1
                    queue.append((nx, ny))
                    ans = max(ans, zido2[ny][nx])
    return ans


h, w = map(int, input().split())

zido = [list(input()) for _ in range(h)]
res = 0
for i in range(h):
    for j in range(w):
        if zido[i][j] == "L":
            res = max(res, bfs(j, i))

print(res - 1)
