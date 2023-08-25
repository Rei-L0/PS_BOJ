import heapq, sys

n = int(sys.stdin.readline().rstrip())
data = []
for _ in range(n):
    for i in list(map(int, sys.stdin.readline().rstrip().split())):
        if len(data) < n:
            heapq.heappush(data, i)
        if data[0] < i:
            heapq.heappop(data)
            heapq.heappush(data, i)

print(data[0])
