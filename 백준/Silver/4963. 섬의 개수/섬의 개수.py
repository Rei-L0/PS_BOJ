import sys
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visit[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < h and -1 < ny < w:
                if not visit[nx][ny] and data[nx][ny] == 1:
                    visit[nx][ny] = True
                    queue.append((nx, ny))


while True:
    w, h = map(int, sys.stdin.readline().rstrip().split())
    data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(h)]

    if w == 0 and h == 0:
        break
    dx = [1, 1, 1, -1, -1, -1, 0, 0]
    dy = [0, -1, 1, 0, -1, 1, 1, -1]
    visit = [[False] * w for _ in range(h)]

    ans = 0
    for i in range(h):
        for j in range(w):
            if not visit[i][j] and data[i][j] == 1:
                bfs(i, j)
                ans += 1

    print(ans)
