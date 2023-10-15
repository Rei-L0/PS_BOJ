from collections import deque

m, n = map(int, input().split())
data = [list(map(int, input())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
wall_cnt = [[-1] * m for _ in range(n)]
queue = deque()
queue.append((0, 0))
wall_cnt[0][0] = 0

while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < n and -1 < ny < m:
            if wall_cnt[nx][ny] == -1:
                if data[nx][ny] == 0:
                    wall_cnt[nx][ny] = wall_cnt[x][y]
                    queue.appendleft((nx, ny))
                if data[nx][ny] == 1:
                    wall_cnt[nx][ny] = wall_cnt[x][y] + 1
                    queue.append((nx, ny))

print(wall_cnt[n - 1][m - 1])
