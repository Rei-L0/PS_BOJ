import copy, collections

n = int(input())


def check(sx, sy):
    q = collections.deque()
    q.append((sx, sy))
    data[sx][sy] = 0

    while q:
        x, y = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n and data[nx][ny] == -1:
                data[nx][ny] = data[x][y] + 1
                q.append((nx, ny))


sx, sy, ex, ey = map(int, input().split())
dx = [-2, -2, 0, 0, 2, 2]
dy = [-1, 1, -2, 2, -1, 1]
data = [[-1] * n for _ in range(n)]

check(sx, sy)
print(data[ex][ey])
