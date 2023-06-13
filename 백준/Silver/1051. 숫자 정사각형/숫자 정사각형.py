n, m = map(int, input().split())

data = [list(map(int, input())) for _ in range(n)]

ans = 0

for i in range(n):
    for j in range(m):
        start = data[i][j]
        for k in range(j + 1, m):
            if data[i][k] == start:
                x = k - j
                if i + x < n:
                    if start == data[i + x][j] and start == data[i + x][k]:
                        ans = max(ans, (x + 1) ** 2)

print(ans if ans else 1)
