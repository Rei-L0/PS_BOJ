n, x = map(int, input().split())
data = list(map(int, input().split()))

ans = 2001

for i in range(1, n):
    ans = min(ans, data[i - 1] + data[i])

print(ans * x)
