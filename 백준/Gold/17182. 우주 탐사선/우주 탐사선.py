n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]


visited = [False] * n
visited[m] = True


def check(cur, cost, cnt):
    global answer
    if cnt == n:
        answer = min(answer, cost)
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            check(i, cost + data[cur][i], cnt + 1)
            visited[i] = False


for k in range(n):
    for i in range(n):
        for j in range(n):
            data[i][j] = min(data[i][j], data[i][k] + data[k][j])

answer = 10**6
check(m, 0, 1)
print(answer)
