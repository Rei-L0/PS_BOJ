import math
import sys

R, G = map(int, sys.stdin.readline().split())


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


li = []

temp = gcd(R, G)
sqrt_temp = math.sqrt(temp)  # 루트처리

for i in range(1, int(sqrt_temp) + 1):
    if temp % i == 0:
        li.append(i)
        if temp // i == i:
            continue
        li.append(temp // i)

for i in li:
    print(i, R // i, G // i)
