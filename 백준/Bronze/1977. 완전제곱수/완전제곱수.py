M = int(input())
N = int(input())

res, d_min = 0, 0
for i in range(M, N+1):
    if i**0.5 % 1 == 0:
        res += i
        if d_min == 0:
            d_min = i

if d_min == 0:
    print(-1)
else:
    print(res)
    print(d_min)
