def check(s):
    stack = list()

    for i in s:
        if i not in stack:
            stack.append(i)
        else:
            if stack[-1] != i:
                return 0
    return 1


n = int(input())

ans = 0

for _ in range(n):
    x = list(input())
    ans += check(x)

print(ans)
