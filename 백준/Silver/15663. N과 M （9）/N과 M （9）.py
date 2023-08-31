from itertools import permutations

n, m = map(int, input().split())
data = list(map(int, input().split()))
ans = sorted(list(set(permutations(data, m))))
for i in ans:
    print(*i)
