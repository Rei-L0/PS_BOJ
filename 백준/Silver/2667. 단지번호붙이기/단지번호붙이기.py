def dfs(x, y):
    stack = []
    stack.append([x, y])
    ans = 1
    data[x][y] = 0
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < n and -1 < ny < n:
                if data[nx][ny] == 1:
                    stack.append([nx, ny])
                    data[nx][ny] = 0
                    ans += 1
    return ans


n = int(input())

data = [list(map(int, input())) for _ in range(n)]
cnt = 0
ans_list = list()
for i in range(n):
    for j in range(n):
        if data[i][j] == 1:
            cnt += 1
            ans_list.append(dfs(i, j))
ans_list.sort()
print(cnt)
for i in ans_list:
    print(i)
