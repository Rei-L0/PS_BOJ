tc = int(input())

for _ in range(tc):
    n = int(input())
    data = list(map(int, input().split()))
    data.sort()
    data = data[::2] + sorted(data[1::2], reverse=True)
    ans = 0
    for i in range(n):
        ans = max(abs(data[i - 1] - data[i]), ans)
    print(ans)
