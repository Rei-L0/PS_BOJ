from collections import deque


def bfs_on(x, y, target_color):
    queue = deque()
    queue.append((x, y))
    on_visit[y][x] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if target_color == "R" or target_color == "G":
                    if (color[ny][nx] == "R" or color[ny][nx] == "G") and not on_visit[
                        ny
                    ][nx]:
                        queue.append((nx, ny))
                        on_visit[ny][nx] = True
                else:
                    if color[ny][nx] == target_color and not on_visit[ny][nx]:
                        queue.append((nx, ny))
                        on_visit[ny][nx] = True


def bfs_off(x, y, target_color):
    queue = deque()
    queue.append((x, y))
    off_visit[y][x] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if target_color == color[ny][nx] and not off_visit[ny][nx]:
                    queue.append((nx, ny))
                    off_visit[ny][nx] = True


n = int(input())
color = [list(input()) for _ in range(n)]

on = 0
on_visit = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not on_visit[i][j]:
            bfs_on(j, i, color[i][j])
            on += 1

off = 0
off_visit = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not off_visit[i][j]:
            bfs_off(j, i, color[i][j])
            off += 1

print(f"{off} {on}")
