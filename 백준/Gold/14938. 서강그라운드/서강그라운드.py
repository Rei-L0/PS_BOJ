n, m, r = map(int, input().split())

item = [0] + list(map(int, input().split()))

d = [[16] * (n + 1) for _ in range(n + 1)]

for i in range(r):
    s, e, w = map(int, input().split())
    d[s][e] = w
    d[e][s] = w

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                d[i][j] = 0
            else:
                d[i][j] = min(d[i][j], d[i][k] + d[k][j])

ans = 0

for i in range(1, n + 1):
    tmp = 0
    for j in range(1, n + 1):
        if d[i][j] <= m:
            tmp += item[j]
    ans = max(tmp, ans)

print(ans)
