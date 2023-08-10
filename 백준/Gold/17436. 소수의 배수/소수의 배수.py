from functools import reduce
from itertools import combinations


def f(x, y):
    return x * y


n, m = map(int, input().split())
data = list(map(int, input().split()))
answer = 0


for i in range(1, n + 1):
    for j in combinations(data, i):
        answer += (-1) ** (i - 1) * (m // reduce(f, j))
print(answer)
