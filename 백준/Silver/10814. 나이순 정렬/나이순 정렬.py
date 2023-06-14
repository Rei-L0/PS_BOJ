n = int(input())

user = [list(input().split()) for _ in range(n)]

user.sort(key=lambda x: [int(x[0])])

for i in user:
    print(*i)
