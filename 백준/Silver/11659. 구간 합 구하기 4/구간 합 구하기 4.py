import sys

input = sys.stdin.readline
n, m = map(int, input().split())

data = [0] + list(map(int, input().split()))

for i in range(2, n + 1):
    data[i] += data[i - 1]

for _ in range(m):
    x, y = map(int, input().split())
    print((data[y] - data[x - 1]))
