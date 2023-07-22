n = int(input())


def check(x, y, num):
    check_val = data[x][y]
    for i in range(num):
        for j in range(num):
            if data[x + i][y + j] != check_val:
                return divide(x, y, num)
    ans.append(str(check_val))


def divide(x, y, num):
    ans.append("(")
    for i in range(0, num // 2 + 1, num // 2):
        for j in range(0, num // 2 + 1, num // 2):
            check(x + i, y + j, num // 2)
    ans.append(")")


data = [list(map(int, input())) for _ in range(n)]
ans = []
check(0, 0, n)
print("".join(ans))
