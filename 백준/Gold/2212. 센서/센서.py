n = int(input())
k = int(input())
data = list(map(int, input().split()))
data.sort()
dis = []

if n > k:
    for i in range(1, n):
        dis.append(data[i] - data[i - 1])

    dis.sort()
    ans = data[-1] - data[0]
    for _ in range(k - 1):
        ans -= dis.pop()
else:
    ans = 0
print(ans)
