import sys

n = int(sys.stdin.readline())

data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

data.sort()

ans = 0
for i in range(1, n + 1):
    ans += abs(i - data[i - 1])
print(ans)
