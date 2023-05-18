n, m = map(int, input().split())

data = list(map(int, input().split()))

ans = 0
interval_sum = 0
end = 0

for start in range(n):
    while interval_sum < m and end < n:
        interval_sum += data[end]
        end += 1
    if interval_sum == m:
        ans += 1
    interval_sum -= data[start]
print(ans)
