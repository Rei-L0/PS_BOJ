from collections import deque


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visit[x][y] = True
    union = [(x, y)]
    csum = data[x][y]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if (
                    data[x][y] + l <= data[nx][ny] <= data[x][y] + r
                    or data[x][y] - r <= data[nx][ny] <= data[x][y] - l
                ) and not visit[nx][ny]:
                    q.append((nx, ny))
                    visit[nx][ny] = True
                    union.append((nx, ny))
                    csum += data[nx][ny]
    if len(union) > 1:
        for x, y in union:
            data[x][y] = csum // len(union)
        return True
    return False


n, l, r = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
day = 0

while True:
    visit = [[False] * n for _ in range(n)]
    check = False
    for i in range(n):
        for j in range(n):
            if not visit[i][j]:
                if bfs(i, j):
                    check = True
    if check:
        day += 1
    else:
        print(day)
        break
