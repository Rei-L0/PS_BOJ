def check(x, y, n):
    chk = data[y][x]
    for i in range(y, y + n):
        for j in range(x, x + n):
            if data[i][j] != chk:
                return -1
    return chk


def div(x, y, n):
    global blue
    global white
    res = check(x, y, n)
    if res == 1:
        blue += 1
        return
    elif res == 0:
        white += 1
        return
    else:
        for i in range(y, y + n, n // 2):
            for j in range(x, x + n, n // 2):
                div(j, i, n // 2)


n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
blue = white = 0

div(0, 0, n)

print(white)
print(blue)
