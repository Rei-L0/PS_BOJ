n = 19
arr = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 1, 0, -1]  # 하(↓), 우하(⬊), 우(➞), 우상(⬈)
dy = [0, 1, 1, 1]


def omok():
    for x in range(n):
        for y in range(n):
            if arr[x][y]:
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    cnt = 1

                    if nx < 0 or ny < 0 or nx >= n or ny >= n:
                        continue

                    while 0 <= nx < n and 0 <= ny < n and arr[x][y] == arr[nx][ny]:
                        cnt += 1

                        if cnt == 5:
                            if (
                                0 <= nx + dx[i] < n
                                and 0 <= ny + dy[i] < n
                                and arr[nx][ny] == arr[nx + dx[i]][ny + dy[i]]
                            ):  
                                break
                            if (
                                0 <= x - dx[i] < n
                                and 0 <= y - dy[i] < n
                                and arr[x][y] == arr[x - dx[i]][y - dy[i]]
                            ):  
                                break
                            return arr[x][y], x + 1, y + 1  

                        nx += dx[i]
                        ny += dy[i]
    return 0, -1, -1  


color, x, y = omok()
if not color:
    print(color)
else:
    print(color)
    print(x, y)
