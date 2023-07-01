def dfs(start):
    stack = [start]
    visit[start] = True

    while stack:
        x = stack.pop()
        for next in graph[x]:
            if not visit[next]:
                stack.append(next)
                visit[next] = True


t = int(input())

for _ in range(t):
    n = int(input())
    p = list(map(int, input().split()))
    graph = [[] for _ in range(n + 1)]
    visit = [False] * (n + 1)
    cnt = 0

    for i in range(n):
        graph[i + 1].append(p[i])

    for i in range(1, n + 1):
        if not visit[i]:
            cnt += 1
            dfs(i)

    print(cnt)
