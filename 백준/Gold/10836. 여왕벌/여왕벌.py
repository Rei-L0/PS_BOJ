import sys
from collections import deque


def grow(l):
    grow_size = [[0] * m for _ in range(m)]
    for i in range(m - 1, -1, -1):
        grow_size[i][0] += l.popleft()
    for i in range(1, m):
        grow_size[0][i] += l.popleft()

    for i in range(m):
        for j in range(m):
            if i == 0:
                data[i][j] += grow_size[i][j]
            elif j == 0:
                data[i][j] += grow_size[i][j]
            else:
                data[i][j] += grow_size[0][j]


m, days = map(int, sys.stdin.readline().rstrip().split())

data = [[1] * m for _ in range(m)]
grow_list = [0] * (2 * m - 1)

for day in range(days):
    zero, one, two = map(int, sys.stdin.readline().rstrip().split())
    tmp = [0] * zero + [1] * one + [2] * two
    for i in range(2 * m - 1):
        grow_list[i] += tmp[i]

grow(deque(grow_list))

for i in data:
    print(*i)
