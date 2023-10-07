n = int(input())

door = [False] * (n + 1)
for i in list(map(int, input().split())):
    door[i] = True
oper_num = int(input())
oper = [int(input()) for _ in range(oper_num)]

ans = 2147000000


def check(idx, cnt, cur_door):
    global ans
    if idx == oper_num:
        ans = min(ans, cnt)
        return

    cur = oper[idx]
    for i in range(cur, -1, -1):
        if cur_door[i]:
            tmp = cur_door[:]
            tmp[i], tmp[cur] = tmp[cur], tmp[i]
            check(idx + 1, cnt + abs(cur - i), tmp)
    for i in range(cur, n + 1):
        if cur_door[i]:
            tmp = cur_door[:]
            tmp[i], tmp[cur] = tmp[cur], tmp[i]
            check(idx + 1, cnt + abs(cur - i), tmp)


check(0, 0, door)
print(ans)
