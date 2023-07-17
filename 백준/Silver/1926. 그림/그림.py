from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visit[x][y] = True
    cnt = 0
    cnt += 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < m:
                if not visit[nx][ny] and data[nx][ny] == 1:
                    visit[nx][ny] = True
                    cnt += 1
                    queue.append((nx, ny))

    return cnt


n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
visit = [[False] * m for _ in range(n)]
ans = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(n):
    for j in range(m):
        if not visit[i][j] and data[i][j] == 1:
            t = bfs(i, j)
            ans.append(t)

print(len(ans))
if not ans:
    print(0)
else:
    print(max(ans))
