from collections import deque


def bfs(x, y):
    q = deque()
    visit = [[-1] * (c + 1) for _ in range(r + 1)]
    q.append((x, y))
    visit[x][y] = 0
    cnt = 0
    ans = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (
                -1 < nx < r + 1
                and -1 < ny < c + 1
                and ((nx == 0 or nx == r) or (ny == 0 or ny == c))
            ):
                if visit[nx][ny] == -1:
                    visit[nx][ny] = visit[x][y] + 1
                    q.append((nx, ny))
                if block[nx][ny] == 1:
                    block[nx][ny] = 0
                    ans += visit[nx][ny]
                    cnt += 1
        if cnt == n:
            return ans


def locate(num, dis):
    if num == 1:
        return 0, dis
    elif num == 2:
        return r, dis
    elif num == 3:
        return dis, 0
    else:
        return dis, c


c, r = map(int, input().split())
block = [[0] * (c + 1) for _ in range(r + 1)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    x, y = locate(a, b)
    block[x][y] = 1

dong_num, dong_dis = map(int, input().split())
sx, sy = locate(dong_num, dong_dis)

print(bfs(sx, sy))
