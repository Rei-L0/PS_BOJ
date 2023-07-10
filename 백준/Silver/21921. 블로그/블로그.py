n, x = map(int, input().split())
data = list(map(int, input().split()))

t_sum = sum(data[:x])
ans = [t_sum]
for i in range(n - x):
    t_sum = t_sum - data[i] + data[i + x]
    ans.append(t_sum)

if max(ans) == 0:
    print("SAD")
else:
    print(max(ans))
    print(ans.count(max(ans)))
