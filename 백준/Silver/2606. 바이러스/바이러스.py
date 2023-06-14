def dfs(start, n):
    stack = list()
    visited = [False] * (n + 1)

    visited[start] = True
    stack.append(start)

    while stack:
        x = stack.pop()
        for i in graph[x]:
            if not visited[i]:
                stack.append(i)
                visited[i] = True

    return visited.count(True)


com_num = int(input())

n = int(input())

graph = [[] for _ in range(com_num + 1)]
for i in range(n):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

print(dfs(1, com_num) - 1)
