def fact(n):
    if n > 1:
        return n * fact(n - 1)
    else:
        return 1


num = str(fact(int(input())))


print(len(num) - len(num.rstrip("0")))
