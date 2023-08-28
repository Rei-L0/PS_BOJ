# 21609
from collections import deque


def bfs(sx, sy, color):
    global avail
    q = deque()
    rainbow = []
    visit[sx][sy] = True
    q.append((sx, sy))
    group = [(sx, sy)]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if not visit[nx][ny]:
                    if data[nx][ny] == color:
                        group.append((nx, ny))
                        q.append((nx, ny))
                        visit[nx][ny] = True
                    if data[nx][ny] == 0:
                        group.append((nx, ny))
                        q.append((nx, ny))
                        visit[nx][ny] = True
                        rainbow.append((nx, ny))

    if len(group) > 1:
        avail.append((group, len(rainbow), sx, sy))
        if rainbow:
            for x, y in rainbow:
                visit[x][y] = False


def gravity():
    for j in range(n):
        idx = n
        tmp = deque()
        for i in range(n - 1, -1, -1):
            if data[i][j] > -1:
                tmp.append(data[i][j])
            if data[i][j] == -1:
                for k in range(idx - 1, i, -1):
                    if tmp:
                        data[k][j] = tmp.popleft()
                    else:
                        data[k][j] = -2
                idx = i
        if tmp:
            for k in range(idx - 1, -1, -1):
                if tmp:
                    data[k][j] = tmp.popleft()
                else:
                    data[k][j] = -2


def rclock():
    tmp = [[] for _ in range(n)]
    for j in range(n - 1, -1, -1):
        for i in range(n):
            tmp[j].append(data[i][j])
    return tmp[::-1]


n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
score = 0

while True:
    avail = []
    visit = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if data[i][j] > 0 and not visit[i][j]:
                bfs(i, j, data[i][j])
    if not avail:
        print(score)
        break
    avail.sort(key=lambda x: (-len(x[0]), -x[1], -x[2], -x[3]))
    score += len(avail[0][0]) ** 2

    # destroy
    for i in avail[0][0]:
        data[i[0]][i[1]] = -2

    gravity()
    data = rclock()
    gravity()
