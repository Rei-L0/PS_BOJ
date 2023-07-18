import sys
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    data[x][y] = 1
    if x == ex and y == ey:
        return 0

    while queue:
        x, y = queue.popleft()
        if x == ex and y == ey:
            return data[x][y] - 1
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < l and -1 < ny < l:
                if data[nx][ny] == -1:
                    data[nx][ny] = data[x][y] + 1
                    queue.append((nx, ny))


t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    l = int(sys.stdin.readline().rstrip())
    sx, sy = map(int, sys.stdin.readline().rstrip().split())
    ex, ey = map(int, sys.stdin.readline().rstrip().split())
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]

    data = [[-1] * l for i in range(l)]

    print(bfs(sx, sy))
