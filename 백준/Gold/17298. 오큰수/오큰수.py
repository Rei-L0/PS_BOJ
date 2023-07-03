n = int(input())

data = [0] + list(map(int, input().split()))

ans = [0] + [-1] * n
stack = []

for i in range(1, n + 1):
    if stack:
        while True:
            if not stack:
                break
            if data[stack[-1]] < data[i]:
                x = stack.pop()
                ans[x] = data[i]
            else:
                break
    stack.append(i)

print(*ans[1:])
