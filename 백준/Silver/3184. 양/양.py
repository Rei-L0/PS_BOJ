import sys
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    sheep = wolf = 0

    while queue:
        global live_sheep
        global live_wolf
        x, y = queue.popleft()

        if data[x][y] == "v":
            wolf += 1
        elif data[x][y] == "o":
            sheep += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < r and -1 < ny < c:
                if not visited[nx][ny] and data[nx][ny] != "#":
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    if sheep > wolf:
        live_sheep += sheep
    else:
        live_wolf += wolf


r, c = map(int, sys.stdin.readline().rstrip().split())
data = [list(sys.stdin.readline().rstrip()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
live_sheep = 0
live_wolf = 0

for i in range(r):
    for j in range(c):
        if not visited[i][j] and data[i][j] != "#":
            bfs(i, j)

print(f"{live_sheep} {live_wolf}")
