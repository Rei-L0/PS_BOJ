n, k = map(int, input().split())

base = [i + 1 for i in range(n)]

ans = list()
ans.append(base.pop(k - 1))
idx = k - 1
while base:
    idx = (idx + k - 1) % len(base)
    ans.append(base.pop(idx))

print(f"<" + ", ".join(map(str, ans)) + ">")
