N = int(input())

data = [0, 1, 3]

for i in range(3, N+1):
    data.append(data[i-2]*2+data[i-1])

print(data[N] % 10007)
