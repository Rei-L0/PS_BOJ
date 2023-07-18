import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
data.sort()

if n % 2 == 0:
    print(data[(n // 2) - 1])
else:
    print(data[n // 2])
