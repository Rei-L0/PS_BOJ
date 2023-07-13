import sys

k, n = map(int, sys.stdin.readline().rstrip().split())

data = [int(sys.stdin.readline().rstrip()) for _ in range(k)]
start, end = 1, max(data)

while start <= end:
    mid = (start + end) // 2
    tmp = 0

    for i in data:
        tmp += i // mid

    if tmp < n:
        end = mid - 1
    else:
        start = mid + 1

print(end)
