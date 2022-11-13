import heapq

N = int(input())

data = []
result = 0

for _ in range(N):
    p, d = map(int, input().split())
    data.append((d, p))

data.sort()

heap = []

for val in data:
    heapq.heappush(heap, val[1])
    if len(heap) > val[0]:
        heapq.heappop(heap)

print(sum(heap))
