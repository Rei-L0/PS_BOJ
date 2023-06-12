w, h = map(int, input().split())
x, y = map(int, input().split())
road = [[0] * (w + 1) for _ in range(h + 1)]
for i in range(1, y + 1):
    for j in range(1, x + 1):
        if i == 1 and j == 1:
            road[i][j] = 1
        elif i == 1 or j == 1:
            road[i][j] = 1
        else:
            road[i][j] = road[i - 1][j] + road[i][j - 1]
            road[i][j] = road[i][j] % (10**6 + 7)
for i in range(y, h + 1):
    for j in range(x, w + 1):
        if i == y or j == x:
            road[i][j] = road[y][x]
        else:
            road[i][j] = road[i - 1][j] + road[i][j - 1]
            road[i][j] = road[i][j] % (10**6 + 7)
print(road[h][w] % (10**6 + 7))