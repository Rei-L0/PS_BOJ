def game(x):
    if x == "Y":
        return 1
    if x == "F":
        return 2
    if x == "O":
        return 3


n, g = input().split()
n = int(n)
data = [input() for _ in range(n)]
data = set(data)

print(len(data) // game(g))
