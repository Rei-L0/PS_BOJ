# 17140

import sys
from collections import Counter


def R(row):
    tmp_data = []
    max_len = 0
    for i in range(row):
        tmp = []
        x = Counter(data[i]).most_common()
        for j in sorted(x, key=lambda x: (x[1], x[0])):
            if j[0] == 0:
                continue
            if len(tmp) == 100:
                break
            tmp.append(j[0])
            tmp.append(j[1])
        max_len = max(max_len, len(tmp))
        tmp_data.append(tmp)

    for i in range(row):
        for j in range(max_len - len(tmp_data[i])):
            tmp_data[i].append(0)

    return tmp_data


r, c, k = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(3)]
time = 0

while time <= 100:
    if len(data) >= r and len(data[0]) >= c:
        if data[r - 1][c - 1] == k:
            break
    if len(data) >= len(data[0]):
        data = R(len(data))
    else:
        data = list(map(list, zip(*data)))
        data = R(len(data))
        data = list(map(list, zip(*data)))
    time += 1

if time > 100:
    time = -1
print(time)
