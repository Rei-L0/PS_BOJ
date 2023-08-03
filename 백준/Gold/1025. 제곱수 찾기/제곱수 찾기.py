import math

n, m = map(int, input().split())

a = [list(input()) for _ in range(n)]

ans = -1
for i in range(n):
    for j in range(m):
        for i_weight in range(-n, n):
            for j_weight in range(-m, m):
                num = ""
                x, y = i, j
                while -1 < x < n and -1 < y < m:
                    num += a[x][y]
                    if i_weight == 0 and j_weight == 0:
                        break
                    if int(math.sqrt(int(num))) ** 2 == int(num):
                        ans = max(ans, int(num))
                    x += i_weight
                    y += j_weight

print(ans)
