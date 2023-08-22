import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())
tmp = []

for _ in range(n):
    name, ext = sys.stdin.readline().rstrip().split(".")
    tmp.append(ext)
answer = Counter(tmp).most_common()
for i in sorted(answer, key=lambda x: x[0]):
    print(*i)
