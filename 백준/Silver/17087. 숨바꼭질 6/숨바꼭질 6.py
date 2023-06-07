import math
from functools import reduce

n, s = map(int, input().split())

bro = list(map(int, input().split()))

for i in range(n):
    bro[i] = abs(bro[i] - s)
print(reduce(math.gcd, bro))
