import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

ans = 0
include_s = dict()

for i in range(n):
    x = sys.stdin.readline().rstrip()
    include_s[x] = 1
for i in range(m):
    x = sys.stdin.readline().rstrip()
    if x in include_s:
        ans += 1

print(ans)
