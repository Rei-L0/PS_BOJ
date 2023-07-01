def check(x, y, n):
    chk = data[y][x]
    for i in range(y, y + n):
        for j in range(x, x + n):
            if chk != data[i][j]:
                return -3

    return chk


def start(x, y, n):
    z = check(x, y, n)
    if z == -1:
        cnt[0] += 1
    elif z == 0:
        cnt[1] += 1
    elif z == 1:
        cnt[2] += 1
    else:
        for i in range(y, y + n, n // 3):
            for j in range(x, x + n, n // 3):
                start(j, i, n // 3)


N = int(input())

cnt = [0, 0, 0]

data = [list(map(int, input().split())) for _ in range(N)]

start(0, 0, N)

print(cnt[0])
print(cnt[1])
print(cnt[2])
