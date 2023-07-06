import sys

n = int(sys.stdin.readline().rstrip())

for i in range(n):
    l, c, r = map(int, sys.stdin.readline().rstrip().split())
    if i == 0:
        max_val = [l, c, r]
        min_val = [l, c, r]
    else:
        max_val = [
            l + max(max_val[0], max_val[1]),
            c + max(max_val[0], max_val[1], max_val[2]),
            r + max(max_val[1], max_val[2]),
        ]
        min_val = [
            l + min(min_val[0], min_val[1]),
            c + min(min_val[0], min_val[1], min_val[2]),
            r + min(min_val[1], min_val[2]),
        ]
print(f"{max(max_val)} {min(min_val)}")
