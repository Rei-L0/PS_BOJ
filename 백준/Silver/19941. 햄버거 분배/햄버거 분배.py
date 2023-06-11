n, k = map(int, input().split())

data = list(input())

for i in range(n):
    if data[i] == "P":
        for j in range(i - k, min(i + k + 1, n)):
            if j < 0:
                continue
            if data[j] == "H":
                data[i] = 1
                data[j] = -1
                break
print(data.count(1))
