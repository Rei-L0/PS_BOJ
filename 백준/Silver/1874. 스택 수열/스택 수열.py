from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
stack = []
ans = []

cur = 0
idx = 0

while idx != n:
    if not stack:
        stack.append(cur)
    else:
        if stack[-1] == data[idx]:
            stack.pop()
            ans.append("-")
            idx += 1
        elif stack[-1] < data[idx]:
            ans.append("+")
            cur += 1
            stack.append(cur)
        else:
            ans = "NO"
            break


if ans == "NO":
    print(ans)
else:
    for i in ans:
        print(i)
