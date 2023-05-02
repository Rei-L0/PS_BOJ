N = int(input())


def prime(n):
    for j in range(2, i):
        if i % j == 0:
            return 0
    return 1


num = list(map(int, input().split()))
res = 0
for i in num:
    if i > 1:
        res += prime(i)
print(res)
