n = int(input())

ans = [list(map(int, input().split())) for _ in range(n)]

ans.sort(key=lambda x: (x[0], x[1]))

for i in ans:
    print(*i)