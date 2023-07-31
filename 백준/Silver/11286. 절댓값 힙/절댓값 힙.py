import heapq, sys

n = int(sys.stdin.readline().rstrip())
heap = []

for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    if x == 0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap, (abs(x), x))
