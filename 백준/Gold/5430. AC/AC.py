import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())
for i in range(t):
    oper = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline().rstrip())
    if n != 0:
        data = list(map(int, sys.stdin.readline().lstrip("[").rstrip("]\n").split(",")))
    else:
        data = list(sys.stdin.readline().lstrip("[").rstrip("]\n"))
    if n < oper.count("D"):
        print("error")
    else:
        q = deque(data)
        cnt = 0
        for i in oper:
            if i == "R":
                cnt += 1
            else:
                if cnt % 2 == 0:
                    q.popleft()
                else:
                    q.pop()
        if cnt % 2 == 0:
            print(f"[{','.join(map(str,q))}]")
        else:
            q.reverse()
            print(f"[{','.join(map(str,q))}]")
