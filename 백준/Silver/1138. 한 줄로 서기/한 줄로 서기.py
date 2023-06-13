n = int(input())

data = [0] + list(map(int, input().split()))

ans = list()

for i in range(n, 0, -1):
    ans.insert(data[i], i)
print(*ans)
