def check(s):
    stack = []
    for i in s:
        if i == "(":
            stack.append(i)
        if i == ")":
            if not stack:
                return "NO"
            if stack[-1] == "(":
                stack.pop()
            else:
                return "NO"
    if stack:
        return "NO"
    else:
        return "YES"


n = int(input())

for _ in range(n):
    x = input()
    print(check(x))
