n = int(input())
data = list(map(int, input().split()))
ans = [0] * n
stack = []
for i in range(n - 1, -1, -1):
    if not stack:
        stack.append((i, data[i]))
    else:
        while stack and data[i] > stack[-1][1]:
            idx, val = stack.pop()
            ans[idx] = i + 1
        stack.append((i, data[i]))

print(*ans)
