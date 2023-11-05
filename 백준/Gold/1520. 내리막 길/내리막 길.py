n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def find_route(x, y):
    if x == n - 1 and y == m - 1:
        return 1

    if visited[x][y] != -1:
        return visited[x][y]

    ways = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < n and -1 < ny < m and data[x][y] > data[nx][ny]:
            ways += find_route(nx, ny)

    visited[x][y] = ways

    return visited[x][y]


visited = [[-1] * m for _ in range(n)]
print(find_route(0, 0))
