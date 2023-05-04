T = int(input())

data = [0, 1, 2, 4]+[0]*100

for x in range(4, 100):
    data[x] = data[x-1]+data[x-2]+data[x-3]

for i in range(T):
    n = int(input())
    print(data[n])
