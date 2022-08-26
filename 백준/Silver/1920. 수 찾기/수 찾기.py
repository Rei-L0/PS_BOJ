N = int(input())

data = set(map(int, input().split()))

M = int(input())

data2 = list(map(int, input().split()))

for i in data2:
    if i in data:
        print(1)
    else:
        print(0)
