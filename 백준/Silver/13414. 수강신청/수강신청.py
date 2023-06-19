import sys

k, l = map(int, sys.stdin.readline().rstrip().split())

wait = dict()
data = [sys.stdin.readline().rstrip() for _ in range(l)]

for i in range(l):
    wait[data[i]] = i

sort_dict = sorted(wait.items(), key=lambda item: item[1])
for i in sort_dict[:k]:
    print(i[0])
