k = int(input())
data = [0] + list(map(int, input().split()))


def tree(root, depth, n):
    ans[depth].append(data[root])
    if n == 0:
        return
    tree(root - n, depth + 1, n // 2)
    tree(root + n, depth + 1, n // 2)


if k != 1:
    ans = [[] for _ in range(k)]
    tree(2 ** (k - 1), 0, 2 ** (k - 2))
    for i in ans:
        print(*i)
else:
    print(data[1])
