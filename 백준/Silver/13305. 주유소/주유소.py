n = int(input())

city = list(map(int, input().split()))

oil = list(map(int, input().split()))

cnt = city[0]
price = oil[0]
ans = 0
for i in range(1, n - 1):
    if oil[i] < price:
        ans += price * cnt
        price = oil[i]
        cnt = city[i]
    else:
        cnt += city[i]
ans += price * cnt
print(ans)
