import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    data = list(map(int, sys.stdin.readline().rstrip().split()))

    max_price = 0
    ans = 0
    for i in range(n - 1, -1, -1):
        if data[i] > max_price:
            max_price = data[i]
        if data[i] < max_price:
            ans += max_price - data[i]
    print(ans)
