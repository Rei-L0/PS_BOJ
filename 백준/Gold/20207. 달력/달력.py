import sys

input = sys.stdin.readline

n = int(input())
arr = [0] * 366
ans = 0

for i in range(n):
    start, end = map(int, input().split())
    while start <= end:
        arr[start] += 1
        start += 1

rows, cols = 0, 0

for i in range(366):
    if arr[i] == 0:
        ans += rows * cols
        rows, cols = 0, 0
        continue

    rows += 1
    cols = max(cols, arr[i])

print(ans + rows * cols)
