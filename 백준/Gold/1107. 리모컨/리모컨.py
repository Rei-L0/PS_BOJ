import sys


def check(num):
    num = list(str(num))
    chk = 0
    for i in range(len(num)):
        if avail_btn[int(num[i])]:
            chk += 1
        else:
            return
    if chk == len(num):
        return True


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
button = list(map(int, sys.stdin.readline().split()))
avail_btn = [False] * 10

for i in range(10):
    if i not in button:
        avail_btn[i] = True

ans1 = abs(N - 100)
ans2 = 1000000
if M != 10:
    up, down = N, N
    ans2 = 0
    while True:
        if down >= 0:
            if check(down):
                ans2 += len(str(down))
                break
        if check(up):
            ans2 += len(str(up))
            break
        up += 1
        down -= 1
        ans2 += 1

print(min(ans1, ans2))
