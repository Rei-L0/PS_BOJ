N = int(input())
for _ in range(N):
    x = list(input())
    res, a = 0, 0
    for i in x:
        if i == 'O':
            a += 1
            res += a
        else:
            a = 0
    print(res)
