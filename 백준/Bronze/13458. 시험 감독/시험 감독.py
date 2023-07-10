import sys

n = int(sys.stdin.readline().rstrip())
if n > 1:
    a = list(map(int, sys.stdin.readline().rstrip().split()))
else:
    a = int(sys.stdin.readline().rstrip())
b, c = map(int, sys.stdin.readline().rstrip().split())

ans = 0
if n > 1:
    for i in a:
        if i - b <= 0:
            ans += 1
        else:
            ans += 1
            if (i - b) % c == 0:
                ans += (i - b) // c
            else:
                ans += (i - b) // c + 1
else:
    ans += 1
    if (a - b) % c == 0:
        ans += (a - b) // c
    else:
        ans += (a - b) // c + 1
print(ans)
