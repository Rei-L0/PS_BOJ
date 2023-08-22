from math import gcd
from functools import reduce

n = int(input())
a = reduce(lambda x, y: x * y, map(int, input().split()))
m = int(input())
b = reduce(lambda x, y: x * y, map(int, input().split()))
answer = str(gcd(a, b))
if len(answer) > 9:
    print(answer[:-10:-1][::-1])
else:
    print(answer)
