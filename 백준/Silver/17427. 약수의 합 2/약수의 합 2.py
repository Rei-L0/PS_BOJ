res = 0
N = int(input())
for x in range(1, N+1):
    res += N//x*x
print(res)
