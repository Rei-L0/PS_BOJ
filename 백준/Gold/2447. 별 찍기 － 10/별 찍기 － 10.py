n = int(input())

output = [[] for _ in range(n)]


def star(y, n):
    if n == 3:
        for i in range(n):
            for j in range(n):
                if (y + i) % 3 == 1 and j % 3 == 1:
                    output[y + i].append(" ")
                    continue
                output[y + i].append("*")
        return
    for i in range(0, n, n // 3):
        for j in range(0, n, n // 3):
            if n // 3 <= i < (n // 3) * 2 and n // 3 <= j < (n // 3) * 2:
                blank(y + i, n // 3)
                continue
            star(y + i, n // 3)


def blank(y, n):
    for i in range(n):
        for j in range(n):
            output[y + i].append(" ")


star(0, n)
for i in output:
    print("".join(i))
