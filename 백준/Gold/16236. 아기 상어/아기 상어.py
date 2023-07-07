import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

INF = 123456789
size = 2
eat_cnt = 0
sx, sy = 0, 0

for i in range(n):
    for j in range(n):
        if data[i][j] == 9:
            sx, sy = i, j
            data[i][j] = 0


def bfs():
    queue = deque([(sx, sy)])
    visit = [[-1] * (n) for _ in range(n)]
    visit[sx][sy] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if size >= data[nx][ny] and visit[nx][ny] == -1:
                    visit[nx][ny] = visit[x][y] + 1
                    queue.append((nx, ny))
    return visit


def find(lst):
    x, y = 0, 0
    min_dis = INF
    for i in range(n):
        for j in range(n):
            if lst[i][j] != -1 and 1 <= data[i][j] < size:
                if lst[i][j] < min_dis:
                    min_dis = lst[i][j]
                    x, y = i, j
    if min_dis == INF:
        return False
    else:
        return x, y, min_dis


ans = 0

while True:
    res = find(bfs())

    if not res:
        print(ans)
        break
    else:
        sx, sy = res[0], res[1]
        ans += res[2]
        data[sx][sy] = 0
        eat_cnt += 1

    if size <= eat_cnt:
        size += 1
        eat_cnt = 0
