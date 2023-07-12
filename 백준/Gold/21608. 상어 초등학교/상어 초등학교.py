n = int(input())


def chk(student, like):
    avail = []
    for y in range(n):
        for x in range(n):
            cnt = 0
            blank = 0
            if shark[y][x] == 0:
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if -1 < nx < n and -1 < ny < n:
                        if shark[ny][nx] in like:
                            cnt += 1
                        if shark[ny][nx] == 0:
                            blank += 1
                avail.append((cnt, blank, x, y))
    avail.sort(key=lambda x: (-x[0], -x[1], x[3], x[2]))
    shark[avail[0][3]][avail[0][2]] = student
    fin_chk.append((avail[0][2], avail[0][3], like))


def satis(x, y, like):
    cnt = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < n and -1 < ny < n:
            if shark[ny][nx] in like:
                cnt += 1
    if cnt == 0:
        return 0
    else:
        return 10 ** (cnt - 1)


shark = [[0] * n for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
fin_chk = []
ans = 0

for _ in range(n**2):
    data = list(map(int, input().split()))
    chk(data[0], data[1:])

for i in range(n**2):
    ans += satis(fin_chk[i][0], fin_chk[i][1], fin_chk[i][2])
print(ans)
