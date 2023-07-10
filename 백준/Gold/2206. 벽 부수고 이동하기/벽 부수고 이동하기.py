import sys
from collections import deque

n, m = map(int, sys.stdin.readline().rstrip().split())
visit = [[[0] * 2 for _ in range(m)] for _ in range(n)]
data = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]


def bfs(x, y, z):
    queue = deque()
    queue.append((x, y, z))
    visit[x][y][z] = 1

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while queue:
        x, y, z = queue.popleft()
        if x == n - 1 and y == m - 1:
            return visit[x][y][z]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if data[nx][ny] == 1 and z == 0:
                    visit[nx][ny][1] = visit[x][y][0] + 1
                    queue.append((nx, ny, 1))
                elif data[nx][ny] == 0 and visit[nx][ny][z] == 0:
                    visit[nx][ny][z] = visit[x][y][z] + 1
                    queue.append((nx, ny, z))
    return -1


print(bfs(0, 0, 0))
