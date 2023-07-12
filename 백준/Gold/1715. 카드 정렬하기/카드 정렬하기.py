import sys, heapq

n = int(sys.stdin.readline().rstrip())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

heapq.heapify(data)
ans = 0
while len(data) > 1:
    x = heapq.heappop(data)
    y = heapq.heappop(data)
    heapq.heappush(data, x + y)
    ans += x + y

print(ans)
