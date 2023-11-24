n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
stack = []
stack.append((0, 0, 1))

ans = 0

dx = [0, 1, 1]
dy = [1, 0, 1]

# 0 가로 1 세로 2 대각선
while stack:
    d, x, y = stack.pop()

    if x == n - 1 and y == n - 1:
        ans += 1

    for i in range(3):
        if d == 0:
            if i == 1:
                continue
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if data[nx][ny] == 0:
                    if i == 2:
                        if data[nx][y] == 1 or data[x][ny] == 1:
                            continue
                    stack.append((i, nx, ny))
        elif d == 1:
            if i == 0:
                continue
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if data[nx][ny] == 0:
                    if i == 2:
                        if data[nx][y] == 1 or data[x][ny] == 1:
                            continue
                    stack.append((i, nx, ny))
        else:
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if data[nx][ny] == 0:
                    if i == 2:
                        if data[nx][y] == 1 or data[x][ny] == 1:
                            continue
                    stack.append((i, nx, ny))

print(ans)
