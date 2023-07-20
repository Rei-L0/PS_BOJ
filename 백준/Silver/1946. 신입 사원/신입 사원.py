import sys

t = int(sys.stdin.readline())
for tc in range(t):
    n = int(sys.stdin.readline())
    data = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
    data.sort(key=lambda x: (x[0], x[1]))

    ans = 0
    f, s = 0, 0
    for i in data:
        if f == 0 and s == 0:
            ans += 1
            f = i[0]
            s = i[1]
        else:
            if f > i[0] or s > i[1]:
                f = i[0]
                s = i[1]
                ans += 1
    print(ans)
