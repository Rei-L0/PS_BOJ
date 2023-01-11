def func(dep):
    if len(result) == M:
        cnt = 0
        for i in range(1, len(result)):
            if result[i-1] < result[i]:
                cnt += 1
        if cnt == len(result)-1:
            print(' '.join(map(str, result)))
        return

    for i in range(dep, N):
        result.append(data[i])
        func(dep)
        result.pop()


N, M = map(int, input().split())

data = []

result = []

for i in range(N+1):
    data.append(i)
data.pop(0)

func(0)
