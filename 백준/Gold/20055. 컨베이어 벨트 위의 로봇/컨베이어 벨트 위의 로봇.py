from collections import deque

n, k = map(int, input().split())

data = list(map(int, input().split()))
rovot = deque([False] * n * 2)
conv = deque(data)

ans = 0
while True:
    conv.rotate()
    rovot.rotate()
    if rovot[n - 1]:
        rovot[n - 1] = False
    for i in range(n - 1, -1, -1):
        if rovot[i]:
            if not rovot[i + 1] and conv[i + 1] >= 1:
                rovot[i], rovot[i + 1] = False, True
                conv[i + 1] -= 1
    if rovot[n - 1]:
        rovot[n - 1] = False
    if conv[0] > 0:
        conv[0] -= 1
        rovot[0] = True
    ans += 1
    if conv.count(0) >= k:
        print(ans)
        break
