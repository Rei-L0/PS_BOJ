n = int(input())
data = [int(input()) for _ in range(n)]

cnt = 0
for i in range(n - 1, 0, -1):
    if data[i] <= data[i - 1]:
        cnt += data[i - 1] - (data[i] - 1)
        data[i - 1] = data[i] - 1

print(cnt)
