from itertools import combinations

# 문제 개수, sum(data)>=l, sum(data)<=r, max(data)-min(data)>=x
n, l, r, x = map(int, input().split())
data = list(map(int, input().split()))
ans = 0

for i in range(2, n + 1):
    for j in combinations(data, i):
        if len(j) > 1 and l <= sum(j) <= r and (max(j) - min(j)) >= x:
            ans += 1
print(ans)
