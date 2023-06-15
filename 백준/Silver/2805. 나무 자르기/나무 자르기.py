n, m = map(int, input().split())

tree = list(map(int, input().split()))

h, l = max(tree), 0

while l < h:
    mid = (h + l) // 2 + 1
    s = sum([max(0, i - mid) for i in tree])

    if s >= m:
        l = mid
    else:
        h = mid - 1

print(l)
