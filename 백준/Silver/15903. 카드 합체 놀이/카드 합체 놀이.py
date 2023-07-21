import sys, heapq

n, m = map(int, sys.stdin.readline().rstrip().split())
card = list(map(int, sys.stdin.readline().rstrip().split()))

tmp = 0
heapq.heapify(card)
for _ in range(m):
    tmp = heapq.heappop(card) + heapq.heappop(card)
    heapq.heappush(card, tmp)
    heapq.heappush(card, tmp)

print(sum(card))
