from collections import deque


def destroy(list):
    for x, y in list:
        data[x][y] = "."


def bfs(x, y, color):
    queue = deque()
    queue.append((x, y))
    destroy_list = []

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if -1 < nx < 12 and -1 < ny < 6:
                if (nx, ny) not in destroy_list:
                    if data[nx][ny] == color:
                        destroy_list.append((nx, ny))
                        queue.append((nx, ny))
    if len(destroy_list) >= 4:
        destroy(destroy_list)
        return 1
    else:
        return 0


def down():
    for i in range(6):
        blank = deque()
        for j in range(11, -1, -1):
            if data[j][i] != ".":
                blank.append(data[j][i])
        if len(blank) != 0:
            for j in range(11, -1, -1):
                if blank:
                    data[j][i] = blank.popleft()
                else:
                    data[j][i] = "."


data = [list(input()) for _ in range(12)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ans = 0

while True:
    flag = 0
    for i in range(12):
        for j in range(6):
            if data[i][j] != ".":
                flag = max(flag, bfs(i, j, data[i][j]))
    if flag == 1:
        ans += 1
        down()
    else:
        print(ans)
        break
