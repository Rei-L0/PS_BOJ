import sys
from collections import deque
from itertools import combinations


def bfs(l):
    q = deque(l)
    visit = [[-1] * n for _ in range(n)]
    time = -1
    cnt = 0
    for i in l:
        visit[i[0]][i[1]] = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if visit[nx][ny] == -1 and data[nx][ny] != 1:
                    visit[nx][ny] = visit[x][y] + 1
                    q.append((nx, ny))

    for i in range(n):
        for j in range(n):
            if visit[i][j] == -1:
                cnt += 1
            time = max(time, visit[i][j])

    if wall == cnt:
        return time
    else:
        return -1


n, m = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
wall = 0
virus = []
for i in range(n):
    for j in range(n):
        if data[i][j] == 2:
            virus.append((i, j))
        if data[i][j] == 1:
            wall += 1

answer = []

for i in combinations(virus, m):
    x = bfs(i)
    if x != -1:
        answer.append(x)
if answer:
    print(min(answer))
else:
    print(-1)
