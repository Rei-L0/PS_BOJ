import sys


def select(idx):
    global ans
    if len(live_chichken) == m:
        ans = min(calc_min(live_chichken), ans)
        return
    for i in range(len(chicken)):
        if i <= idx:
            continue
        if chicken[i] not in live_chichken:
            live_chichken.append(chicken[i])
            select(i)
            live_chichken.pop()


def distance(h, c):
    return abs(h[0] - c[0]) + abs(h[1] - c[1])


def calc_min(l):
    tmp = l
    dis = [10**5] * len(house)
    for i in range(len(house)):
        for j in tmp:
            dis[i] = min(dis[i], distance(house[i], j))
    return sum(dis)


n, m = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
house = []
chicken = []
live_chichken = []
ans = 10**7

for i in range(n):
    for j in range(n):
        if data[i][j] == 1:
            house.append((i, j))
        if data[i][j] == 2:
            chicken.append((i, j))

select(-1)
print(ans)
