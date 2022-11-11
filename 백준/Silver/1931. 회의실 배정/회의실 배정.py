N = int(input())

data = []

for _ in range(N):
    s, e = map(int, input().split())
    data.append((e, s))

data.sort()
count = 1
end = data[0][0]

for i in range(1, N):
    if data[i][1] >= end:
        end = data[i][0]
        count += 1

print(count)
