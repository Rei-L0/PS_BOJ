import copy


def dfs(x, y, tmp):
    res = copy.deepcopy(tmp)
    res.append(data[x][y])
    if len(res) == 6:
        if res not in ans:
            ans.append(res)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < 5 and -1 < ny < 5:
            dfs(nx, ny, res)


data = [list(map(int, input().split())) for _ in range(5)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ans = []

for i in range(5):
    for j in range(5):
        dfs(i, j, [])

print(len(ans))
