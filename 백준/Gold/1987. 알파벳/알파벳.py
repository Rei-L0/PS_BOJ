import sys


def dfs(x, y, cnt):
    global ans
    ans = max(cnt, ans)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < r and -1 < ny < c and not data[nx][ny] in chk:
            chk.add(data[nx][ny])
            dfs(nx, ny, cnt + 1)
            chk.remove(data[nx][ny])


r, c = map(int, sys.stdin.readline().rstrip().split())
data = [list(sys.stdin.readline().rstrip()) for _ in range(r)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = 0
chk = set()
chk.add(data[0][0])
dfs(0, 0, 1)
print(ans)
