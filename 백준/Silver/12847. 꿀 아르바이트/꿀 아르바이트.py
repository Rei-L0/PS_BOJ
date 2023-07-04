n, m = map(int, input().split())
t = list(map(int, input().split()))

ans = tmp = sum(t[:m])

for i in range(n - m):
    tmp -= t[i]
    tmp += t[i + m]
    ans = max(ans, tmp)

print(ans)
