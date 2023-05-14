from collections import deque

T = int(input())
gear = [0]

for _ in range(T):
    gear.append(deque(list(map(int, input()))))

K = int(input())

for _ in range(K):
    idx, rot = map(int, input().split())
    chk = [0] * (T + 1)
    chk[idx] = rot
    if idx != 1:
        left = gear[idx][6]
        rot_l = rot
        for i in range(idx - 1, 0, -1):
            if left == gear[i][2]:
                break
            rot_l = -rot_l
            chk[i] = rot_l
            left = gear[i][6]
    if idx != T:
        right = gear[idx][2]
        rot_r = rot
        for i in range(idx + 1, len(gear)):
            if right == gear[i][6]:
                break
            rot_r = -rot_r
            chk[i] = rot_r
            right = gear[i][2]

    for x in range(1, len(gear)):
        if chk[x]:
            gear[x].rotate(chk[x])
res = 0
for i in range(1, len(gear)):
    if gear[i][0]:
        res += 1
print(res)
