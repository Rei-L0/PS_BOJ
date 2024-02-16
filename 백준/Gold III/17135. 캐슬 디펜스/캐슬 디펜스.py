from itertools import combinations
import copy


def monster_down():
    tmp = [0] * m
    for i in range(n):
        for j in range(m):
            data[i][j], tmp[j] = tmp[j], data[i][j]


n, m, d = map(int, input().split())
origin_data = [list(map(int, input().split())) for _ in range(n)]

ans = 0

for y1, y2, y3 in list(combinations(list(range(0, m, 1)), 3)):
    monster = 0
    data = copy.deepcopy(origin_data)
    x = n
    for _ in range(n):
        attack_list = [0] * 3
        dis = [100] * 3
        for j in range(m):
            for i in range(n - 1, -1, -1):
                if data[i][j] == 1:
                    a1 = abs(i - x) + abs(y1 - j)
                    a2 = abs(i - x) + abs(y2 - j)
                    a3 = abs(i - x) + abs(y3 - j)
                    if a1 <= d and a1 < dis[0]:
                        dis[0] = a1
                        attack_list[0] = (i, j)
                    if a2 <= d and a2 < dis[1]:
                        dis[1] = a2
                        attack_list[1] = (i, j)
                    if a3 <= d and a3 < dis[2]:
                        dis[2] = a3
                        attack_list[2] = (i, j)
        for i in set(attack_list):
            if i != 0:
                monster += 1
                data[i[0]][i[1]] = 0
        monster_down()
    ans = max(monster, ans)

print(ans)
