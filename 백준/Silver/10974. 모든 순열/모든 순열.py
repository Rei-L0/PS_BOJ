import itertools

N = int(input())

data = [i for i in range(1, N + 1)]

p = list(itertools.permutations(data, N))

for i in p:
    for j in i:
        print(j, end=" ")
    print()
