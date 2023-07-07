def dfs(s, i):
    visit[s] = True
    x = data[s]
    if not visit[x]:
        dfs(x, i)
    elif visit[x] and x == i:
        ans.append(x)


n = int(input())
data = [0] + [int(input()) for _ in range(n)]
ans = []

for i in range(1, n + 1):
    visit = [False] * (n + 1)
    dfs(i, i)
print(len(ans))
for i in ans:
    print(i)
