from collections import deque
import copy


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    tmp_data = copy.deepcopy(data)
    tmp_data[y][x] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(len(dx)):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < ny < n and -1 < nx < m:
                if tmp_data[ny][nx] == 0:
                    tmp_data[ny][nx] = tmp_data[y][x] + 1
                    queue.append((nx, ny))
                if data[ny][nx] == 1:
                    return tmp_data[y][x] + 1


n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 1, 1, -1, -1, -1, 0, 0]
dy = [1, 0, -1, 1, 0, -1, 1, -1]
ans = 0

for i in range(n):
    for j in range(m):
        if data[i][j] == 0:
            ans = max(ans, bfs(j, i))

print(ans)
