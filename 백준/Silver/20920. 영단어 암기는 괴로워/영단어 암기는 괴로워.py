import sys
from collections import Counter

n, m = map(int, sys.stdin.readline().rstrip().split())
data = [sys.stdin.readline().rstrip() for _ in range(n)]

count = Counter(data)
count = count.most_common()
ans = []
for i in count:
    if len(i[0]) >= m:
        ans.append((i[1], len(i[0]), i[0]))
ans.sort(key=lambda x: (-x[0], -x[1], x[2]))

for i in ans:
    print(i[2])
