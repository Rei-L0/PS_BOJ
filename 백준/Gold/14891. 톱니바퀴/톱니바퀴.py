from collections import deque


def left(idx, t, chk):
    if idx == 0:
        return
    if chk != tobni[idx][2]:
        left(idx - 1, -t, tobni[idx][6])
        tobni[idx].rotate(t)


def right(idx, t, chk):
    if idx == 5:
        return
    if chk != tobni[idx][6]:
        right(idx + 1, -t, tobni[idx][2])
        tobni[idx].rotate(t)


tobni = [[]]

for _ in range(4):
    tobni.append(deque(map(int, input())))

k = int(input())

for _ in range(k):
    num, turn = map(int, input().split())
    left(num - 1, -turn, tobni[num][6])
    right(num + 1, -turn, tobni[num][2])
    tobni[num].rotate(turn)

ans = 0
for i in range(1, 5):
    if tobni[i][0] == 1:
        ans += 2 ** (i - 1)

print(ans)
