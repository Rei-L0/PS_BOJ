import sys

n = int(sys.stdin.readline().rstrip())

data = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
data.sort()
start, end = data[0][0], data[0][1]
answer = 0

for i in data:
    if i[0] > end:
        answer += abs(end - start)
        start = i[0]
        end = i[1]
    else:
        end = max(end, i[1])

print(answer + abs(end - start))
