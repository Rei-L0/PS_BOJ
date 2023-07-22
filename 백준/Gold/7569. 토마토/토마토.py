import sys
from collections import deque

n, m, h = map(int, sys.stdin.readline().rstrip().split())
data = []
visit = [[[False] * n for _ in range(m)] for _ in range(h)]
queue = deque()
dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]
day = 1
flag = True

for _ in range(h):
    tmp = []
    for i in range(m):
        tmp.append(list(map(int, sys.stdin.readline().rstrip().split())))
    data.append(tmp)

for i in range(h):
    for j in range(m):
        for k in range(n):
            if not visit[i][j][k] and data[i][j][k] == 1:
                visit[i][j][k] = True
                queue.append((i, j, k))

while queue:
    x, y, z = queue.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if -1 < nx < h and -1 < ny < m and -1 < nz < n:
            if not visit[nx][ny][nz] and data[nx][ny][nz] == 0:
                data[nx][ny][nz] = data[x][y][z] + 1
                day = max(data[nx][ny][nz], day)
                visit[nx][ny][nz] = True
                queue.append((nx, ny, nz))

for i in range(h):
    for j in range(m):
        for k in range(n):
            if data[i][j][k] == 0:
                flag = False
                break

if not flag:
    print(-1)
else:
    print(day - 1)
