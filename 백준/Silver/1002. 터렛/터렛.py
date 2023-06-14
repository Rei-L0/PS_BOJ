t = int(input())


def calc(x1, y1, x2, y2):
    return ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5


for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    if x1 == x2 and y1 == y2:
        if r1 == r2:
            print(-1)
        else:
            print(0)

    else:
        dir = calc(x1, y1, x2, y2)
        if dir + r1 < r2 or dir + r2 < r1:
            print(0)
        elif dir > r1 + r2:
            print(0)
        elif dir == r1 + r2 or dir == abs(r1 - r2):
            print(1)
        else:
            print(2)
