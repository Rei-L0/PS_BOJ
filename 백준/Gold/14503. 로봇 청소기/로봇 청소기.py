import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())

stat = list()

for _ in range(n):
    x = list(map(int, sys.stdin.readline().split()))
    stat.append(x)

ans = 0

direct = deque([(1, 0), (0, -1), (-1, 0), (0, 1)])
for _ in range(d):
    direct.rotate(-1)

while True:
    chk = 0
    if stat[r][c] == 0:
        ans += 1
        stat[r][c] = -1
    for i in range(4):
        dx, dy = direct[i]
        if stat[r + dx][c + dy] == 0:
            chk += 1
            break
    if chk == 0:
        if stat[r + direct[0][0]][c + direct[0][1]] != 1:
            r = r + direct[0][0]
            c = c + direct[0][1]
            continue
        else:
            break
    else:
        direct.rotate(1)
        if stat[r - direct[0][0]][c - direct[0][1]] == 0:
            r = r - direct[0][0]
            c = c - direct[0][1]

print(ans)
