def dfs(y, x):
    stack = []
    stack.append([y, x])
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while stack:
        y, x = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < ny < n and -1 < nx < m:
                if data[ny][nx] == 1:
                    stack.append([ny, nx])
                    data[ny][nx] = 0


t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    data = [[0] * m for _ in range(n)]
    ans = 0

    for _ in range(k):
        bx, by = map(int, input().split())
        data[by][bx] = 1

    for i in range(n):
        for j in range(m):
            if data[i][j] == 1:
                dfs(i, j)
                ans += 1
    print(ans)
