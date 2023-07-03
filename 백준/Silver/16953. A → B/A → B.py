from collections import deque

a, b = map(int, input().split())

cnt = 1

while True:
    if b % 10 == 1:
        b = b // 10
        cnt += 1
    elif b % 2 == 0:
        b = b // 2
        cnt += 1
    else:
        print(-1)
        break
    if a > b:
        print(-1)
        break
    if a == b:
        print(cnt)
        break
