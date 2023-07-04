import sys

n = int(sys.stdin.readline())
data = [int(sys.stdin.readline()) for _ in range(n)]

data.sort()
ans = -1

for i in range(2, n):
    if data[i] < data[i - 1] + data[i - 2]:
        ans = data[i] + data[i - 1] + data[i - 2]
print(ans)
