def calc(x, y):
    if y == 1:
        return x % c
    else:
        tmp = calc(x, y // 2)
        if y % 2 == 0:
            return tmp * tmp % c
        else:
            return tmp * tmp * a % c


a, b, c = map(int, input().split())

print(calc(a, b))
