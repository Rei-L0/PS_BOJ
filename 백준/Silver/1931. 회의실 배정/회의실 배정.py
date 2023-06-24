import sys

n = int(sys.stdin.readline().rstrip())

data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

data.sort(key=lambda x: (x[1], x[0]))

ans = 1
end = data[0][1]
for i in range(1, n):
    if data[i][0] >= end:
        ans += 1
        end = data[i][1]

print(ans)
