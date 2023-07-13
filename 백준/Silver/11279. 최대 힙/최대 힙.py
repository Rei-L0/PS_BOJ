import sys, heapq

n = int(sys.stdin.readline().strip())
q = []

for _ in range(n):
    num = int(sys.stdin.readline().strip())

    if num == 0:
        if not q:
            print(0)
        else:
            print(-heapq.heappop(q))
    else:
        heapq.heappush(q, -num)
