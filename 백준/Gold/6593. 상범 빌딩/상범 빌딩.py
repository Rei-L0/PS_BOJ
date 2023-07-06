import sys
from collections import deque


def bfs(x, y, z):
    queue = deque()
    visit = [[[0] * c for _ in range(r)] for _ in range(l)]
    visit[z][y][x] = 0
    queue.append((x, y, z))

    dx = [1, -1, 0, 0, 0, 0]
    dy = [0, 0, 1, -1, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]

    while queue:
        x, y, z = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if -1 < nz < l and -1 < ny < r and -1 < nx < c:
                if visit[nz][ny][nx] == 0:
                    if data[nz][ny][nx] == ".":
                        visit[nz][ny][nx] = visit[z][y][x] + 1
                        queue.append((nx, ny, nz))
                    if data[nz][ny][nx] == "E":
                        visit[nz][ny][nx] = visit[z][y][x] + 1
                        return f"Escaped in {visit[nz][ny][nx]} minute(s)."
    return "Trapped!"


while True:
    l, r, c = map(int, sys.stdin.readline().rstrip().split())
    if l == 0:
        break
    data = []
    for _ in range(l):
        x = [list(sys.stdin.readline().rstrip()) for _ in range(r)]
        y = sys.stdin.readline()
        data.append(x)

    ans = ""

    for i in range(l):
        for j in range(r):
            for k in range(c):
                if data[i][j][k] == "S":
                    ans = bfs(k, j, i)

    print(ans)
