def func(res):
    global ans
    if len(data) < 3:
        ans = max(ans, res)
        return
    for i in range(1, len(data) - 1):
        x = data.pop(i)
        target = data[i - 1] * data[i]
        func(res + target)
        data.insert(i, x)


N = int(input())
data = list(map(int, input().split()))
ans = 0

func(0)

print(ans)
