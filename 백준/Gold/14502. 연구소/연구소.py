import sys, copy
from collections import deque


def bfs():
    queue = deque()
    tmp_data = copy.deepcopy(data)
    for i in range(n):
        for j in range(m):
            if tmp_data[i][j] == 2:
                queue.append((i, j))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if tmp_data[nx][ny] == 0:
                    tmp_data[nx][ny] = 2
                    queue.append((nx, ny))

    global ans
    res = 0
    for i in tmp_data:
        res += i.count(0)
    ans = max(res, ans)


def wall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                wall(cnt + 1)
                data[i][j] = 0


n, m = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ans = 0
wall(0)
print(ans)
