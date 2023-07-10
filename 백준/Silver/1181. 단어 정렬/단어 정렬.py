import sys

n = int(sys.stdin.readline().rstrip())
data = list()
for _ in range(n):
    x = sys.stdin.readline().rstrip()
    data.append((x, len(x)))
data = list(set(data))
data.sort(key=lambda x: (x[1], x[0]))

for i in data:
    print(i[0])
