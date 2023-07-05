from collections import deque


n, m = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(m)]
queue = deque()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(m):
    for j in range(n):
        if tomato[i][j] == 1:
            queue.append((j, i))
            tomato[i][j] = 1

ans = 0
flag = 1
while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < n and -1 < ny < m:
            if tomato[ny][nx] == 0:
                queue.append((nx, ny))
                tomato[ny][nx] = tomato[y][x] + 1
for i in tomato:
    ans = max(max(i), ans)
    if 0 in i:
        flag = -1
        print(flag)
        break

if flag == 1:
    print(ans - 1)
