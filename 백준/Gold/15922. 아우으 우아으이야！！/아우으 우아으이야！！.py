import sys

n = int(sys.stdin.readline().rstrip())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
start, end = data[0][0], data[0][1]
answer = 0

for i in range(n):
    s, e = data[i][0], data[i][1]
    if s > end:
        answer += end - start
        start, end = s, e
    else:
        end = max(e, end)

print(answer + (end - start))
