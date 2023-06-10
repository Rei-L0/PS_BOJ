h, w = map(int, input().split())

data = list(map(int, input().split()))

ans = 0

for i in range(h, -1, -1):
    start = end = -1
    while True:
        end = end + 1
        if end > w - 1:
            break
        if data[end] >= i:
            if start == -1:
                start = end
            else:
                ans += end - start - 1
                start = end

print(ans)
