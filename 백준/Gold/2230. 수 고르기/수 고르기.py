import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
data.sort()
answer = 10**10
start, end = 0, 0

while start < len(data) and end < len(data):
    if (data[end] - data[start]) < m:
        end += 1
    else:
        answer = min(answer, (data[end] - data[start]))
        start += 1

print(answer)
