n = int(input())
data = list(map(int, input().split()))

data.sort()
ans = [data[i] * (n - i) for i in range(n)]
print(sum(ans))
