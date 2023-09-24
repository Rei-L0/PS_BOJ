import sys


def melt():
    melt_list = []
    for x in range(n):
        for y in range(m):
            if data[x][y] != 0:
                cnt = 0
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if data[nx][ny] == 0:
                        cnt += 1
                melt_list.append((x, y, cnt))

    if melt_list:
        for x, y, cnt in melt_list:
            data[x][y] = max(data[x][y] - cnt, 0)


def find_island(x, y):
    visit[x][y] = True
    stack = [(x, y)]

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if data[nx][ny] != 0 and not visit[nx][ny]:
                visit[nx][ny] = True
                stack.append((nx, ny))


n, m = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

year = 0

while True:
    year += 1
    melt()
    visit = [[False] * m for _ in range(n)]

    island = 0
    zero_cnt = 0

    for i in range(n):
        zero_cnt += data[i].count(0)
        for j in range(m):
            if data[i][j] > 0 and not visit[i][j]:
                find_island(i, j)
                island += 1
    if island > 1:
        print(year)
        break
    if zero_cnt == n * m:
        print(0)
        break
