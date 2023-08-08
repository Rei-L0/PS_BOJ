import sys


def back(num, l):
    if len(l) == n:
        print(*l)
        sys.exit()
        return True
    if 2 * num in check:
        l.append(2 * num)
        back(2 * num, l)
        l.pop()
    if num % 3 == 0:
        if num // 3 in check:
            l.append(num // 3)
            back(num // 3, l)
            l.pop()


n = int(input())
data = list(map(int, input().split()))
check = {}
answer = []
for i in data:
    check[i] = 1

for i in data:
    if back(i, [i]):
        break
