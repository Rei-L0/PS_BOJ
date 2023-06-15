def dfs(start):
    stack = list()
    stack.append(start)
    visit = [[False] * n for _ in range(n)]
    while stack:
        x = stack.pop()
        for i in range(n):
            if data[x][i] == 1 and not visit[x][i]:
                visit[x][i] = True
                stack.append(i)
                data[start][i] = 1


n = int(input())

data = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    dfs(i)

for i in data:
    print(*i)
