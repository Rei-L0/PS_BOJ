import itertools

N = int(input())

data = list(map(int, input().split()))

p = list(itertools.permutations(data, N))

res = 0
for i in p:
    tmp = 0
    for idx in range(1, len(i)):
        tmp += abs(i[idx - 1] - i[idx])
    res = max(res, tmp)
print(res)
