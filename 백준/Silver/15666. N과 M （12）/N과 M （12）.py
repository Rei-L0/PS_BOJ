def solve(l):
    if len(l) == m:
        print(*l)
        return

    for i in range(len(data)):
        if data[i] >= l[-1]:
            l.append(data[i])
            solve(l)
            l.pop()


n, m = map(int, input().split())

data = list(set(map(int, input().split())))
data.sort()

for i in range(len(data)):
    solve([data[i]])
