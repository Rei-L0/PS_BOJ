from collections import deque

n, k = map(int, input().split())

data = []
prior = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(n):
    input_data = list(map(int, input().split()))
    for j in range(n):
        if input_data[j] != 0:
            prior.append((input_data[j], 0, i, j))
    data.append(input_data)
s, tx, ty = map(int, input().split())
prior.sort(key=lambda x: (x[0]))
prior = deque(prior)

while prior:
    val, cnt, x, y = prior.popleft()
    if cnt == s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < n and -1 < ny < n:
            if data[nx][ny] == 0:
                data[nx][ny] = val
                prior.append((val, cnt + 1, nx, ny))
print(data[tx - 1][ty - 1])
